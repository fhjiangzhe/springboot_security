package com.example.service.impl;

import com.example.domain.PoisonPill;
import com.example.domain.UserBindEntity;
import com.example.repository.UserBindRepository;
import com.example.service.ThreadService;
import com.example.thread.ConsumerThread;
import com.example.thread.ProviderThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

/**
 * Created by JiangZhe on 16/7/26.
 */
@Service
public class ThreadServiceImpl implements ThreadService , ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserBindRepository userBindRepository;

    private static final int NUM_COUNTERS = 10;

    //正常待导入消息消费线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
         this.start();
    }

    @Override
    @Scheduled(fixedRate = 50000)
    public void start() {
//        try {
//            ArrayBlockingQueue<UserBindEntity> queue = new ArrayBlockingQueue<UserBindEntity>(100);
//            ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<String, Integer>();
//
//            for(int i=0;i<NUM_COUNTERS;++i){
//                taskExecutor.execute(new ProviderThread(queue, counts,userBindRepository));
//            }
//
//            Thread parser = new Thread(new ConsumerThread(queue,userBindRepository));//一个生产者
//
//            long start = System.currentTimeMillis();
//            parser.start();
//            parser.join();
//
//            for (int i = 0; i < NUM_COUNTERS; ++i){
//                queue.put(new PoisonPill());
//            }
//
////            taskExecutor.shutdown();
////            taskExecutor.setAwaitTerminationSeconds(600);
//            long end = System.currentTimeMillis();
//            System.out.println("Elapsed time: " + (end - start) + "ms");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
