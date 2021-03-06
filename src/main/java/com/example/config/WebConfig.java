package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * Created by JiangZhe on 16/7/26.
 */
@Configuration
public class WebConfig {

    @Bean
    public  ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
//线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(200);
//线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(5);
//线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(1000);
//线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30000);

        return poolTaskExecutor;
    }

}
