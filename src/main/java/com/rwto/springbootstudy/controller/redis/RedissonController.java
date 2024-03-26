package com.rwto.springbootstudy.controller.redis;

import com.rwto.springbootstudy.service.RedissonDelayQueueService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author renmw
 * @create 2024/1/18 11:14
 **/
@Slf4j
@RestController
public class RedissonController {
    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private RedissonDelayQueueService redissonDelayQueueService;

    @RequestMapping("/redisson")
    public void redissonTest(Integer time) throws InterruptedException {
        String lockKey = "lockKey:123";
        RLock lock = redissonClient.getLock(lockKey);
        if(!lock.tryLock(10, TimeUnit.SECONDS)){
            return;
        }
        try {
            Thread.sleep(time*1000);
            System.out.println(time);
        } catch (InterruptedException e) {

        }finally {
            lock.unlock();
        }

    }


    @RequestMapping("/delayQueue")
    public void delayQueue(Integer time) throws InterruptedException {
        RBlockingDeque<String> test = redissonClient.getBlockingDeque("test");
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(test);
        delayedQueue.offer("test12345678",5, TimeUnit.SECONDS);
        delayedQueue.offer("test212313",5, TimeUnit.SECONDS);
        delayedQueue.offer("test31231231312",8, TimeUnit.SECONDS);

        Thread thread1 = new Thread(() -> {
            while (true){
                try {
                    Object take = test.take();
                    log.info("============================="+take);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true){
                try {
                    Object take = test.take();
                    log.info("============================="+take);
                } catch (InterruptedException e) {
                }
            }

        });

        thread1.start();
        thread2.start();

    }


    @RequestMapping("/delayQueueOffer")
    public void delayQueue(String str) {
        redissonDelayQueueService.offer(str,5L);
    }
}
