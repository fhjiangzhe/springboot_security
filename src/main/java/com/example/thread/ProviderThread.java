package com.example.thread;


import com.example.domain.UserBindEntity;
import com.example.repository.UserBindRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by JiangZhe on 16/7/26.
 */
public class ProviderThread implements Runnable{

    private BlockingQueue<UserBindEntity> queue;
    private ConcurrentMap<String, Integer> counts;
    private HashMap<String, Integer> localCounts;
    private UserBindRepository userBindRepository;


    public ProviderThread(BlockingQueue<UserBindEntity> queue,
                          ConcurrentMap<String, Integer> counts,
                          UserBindRepository userBindRepository){
        this.queue = queue;
        this.counts = counts;
        localCounts = new HashMap<String, Integer>();
        this.userBindRepository = userBindRepository;
    }


    @Override
    public void run() {

        try{
            while(true){
                UserBindEntity take = queue.take();
                    if(take.isPoisonPill()){
                        break;
                    }


                countUserBind(take);
            }
            mergeCounts();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void countUserBind(UserBindEntity userBindEntity){
        Integer currentCount = localCounts.get(userBindEntity.getBindOrgName());
        if (currentCount == null)
            localCounts.put(userBindEntity.getBindOrgName(), 1);
        else
            localCounts.put(userBindEntity.getBindOrgName(), currentCount + 1);

        userBindEntity.setEffectStatus(1);
        userBindRepository.save(userBindEntity);
    }

    private void mergeCounts(){
        for(Map.Entry<String, Integer> e: localCounts.entrySet()){
            String bindOrgName = e.getKey();
            Integer count = e.getValue();
            while(true){
                Integer currentCount = counts.get(bindOrgName);
                if (currentCount == null) {
                    if (counts.putIfAbsent(bindOrgName, count) == null)
                        break;
                } else if (counts.replace(bindOrgName, currentCount, currentCount + count)) {
                    break;
                }
            }

        }
    }
}
