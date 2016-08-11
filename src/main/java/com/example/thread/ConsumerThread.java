package com.example.thread;

import com.example.domain.UserBindEntity;
import com.example.repository.UserBindRepository;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by JiangZhe on 16/7/26.
 */
public class ConsumerThread implements Runnable {

    private BlockingQueue<UserBindEntity> queue;

    private UserBindRepository userBindRepository;

    public ConsumerThread(BlockingQueue<UserBindEntity> queue, UserBindRepository userBindRepository){
        this.queue = queue;
        this.userBindRepository = userBindRepository;
    }

    @Override
    public void run() {
        try {
            List<UserBindEntity> all = userBindRepository.findAll();
            for (UserBindEntity userBindEntity : all) {
                queue.put(userBindEntity);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
