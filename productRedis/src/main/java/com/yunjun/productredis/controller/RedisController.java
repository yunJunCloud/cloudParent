package com.yunjun.productredis.controller;

import lombok.Synchronized;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME: com.yunjun.productredis.controller
 * @NAME: RedisController
 * @USER: jack
 * @DATE: 3/5/2023
 * @PROJECT_NAME: cloudParent
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    final String STR_KEY = "str_key";

    final String LOCK_KEY = "lock_key";

    @RequestMapping(value = "/redisStr", method = RequestMethod.GET)
    public void redisStr(@RequestParam(value = "str") String str) {
        stringRedisTemplate.opsForValue().set(STR_KEY, str);
    }

    @GetMapping(value = "/reduce")
    public void testReduceStr() {
        //模拟下单减少库存
        //如果是分布式下，springboot 多实例（一个项目同时部署多套）下会出现错误
        synchronized (this) {
            Long count = Long.parseLong(stringRedisTemplate.opsForValue().get(STR_KEY));
            if (count > 0) {
                Long realCount = count - 1;
                stringRedisTemplate.opsForValue().set(STR_KEY, String.valueOf(realCount));
                System.out.println("下单成功！,剩余库存" + realCount);
            } else {
                System.out.println("下单失败！,库存不足!");
            }
        }
    }

    /**
     * 采用redis 实现分布式锁的原理
     */
    @GetMapping(value = "/reduce2")
    public void testReduceStr2() {
        //模拟下单减少库存
        //如果是分布式下，springboot 多实例（一个项目同时部署多套）下会出现错误
        String uuid = UUID.randomUUID().toString();
        try {
            //问题2：设置分布式锁过期时间（因为如果stringRedisTemplate.opsForValue().set(STR_KEY, String.valueOf(realCount))这块服务挂掉之后，
            // finally中释放锁的操作也不会执行，为了防止死锁，就需要设置过期时间）
            //stringRedisTemplate.expire(LOCK_KEY,10, TimeUnit.SECONDS);
            //问题4： 如果业务处理时间较长，还未处理完成，锁到期了，释放了，会导致有新的线程过来，出现资源共享问题，怎么解决过期时间问题？如何给锁续命？

            Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(LOCK_KEY, uuid, 10, TimeUnit.SECONDS);
            if (!lock) {
                System.out.println("服务真忙-----");
                return;
            }
            Long count = Long.parseLong(stringRedisTemplate.opsForValue().get(STR_KEY));
            if (count > 0) {
                Long realCount = count - 1;
                stringRedisTemplate.opsForValue().set(STR_KEY, String.valueOf(realCount));
                System.out.println("下单成功！,剩余库存" + realCount);
            } else {
                System.out.println("下单失败！,库存不足!");
            }
        } finally {
            //问题1：分布式锁上锁后一定要解锁，也就是删除key (如果不删除的话，会程序只会执行一次)
            //问题3：每次删除的锁，是当前线程自己加的锁
            if (uuid.equals(redisTemplate.opsForValue().get(LOCK_KEY))) {
                redisTemplate.delete(LOCK_KEY);
            }
        }
    }

    @GetMapping("/reduce3")
    public void testRedission() {
        RLock lock = redissonClient.getLock(LOCK_KEY);
        try {
            lock.lock();
            Long count = Long.parseLong(stringRedisTemplate.opsForValue().get(STR_KEY));
            if (count > 0) {
                Long realCount = count - 1;
                stringRedisTemplate.opsForValue().set(STR_KEY, String.valueOf(realCount));
                System.out.println("下单成功！,剩余库存" + realCount+"------进程id:"+Thread.currentThread().getId());
            } else {
                System.out.println("下单失败！,库存不足!-----进程id:"+Thread.currentThread().getId());
            }
            Thread.sleep(3);
        } catch (Exception e) {
            //lock.unlock();
        }finally {
            lock.unlock();
        }
    }
}
