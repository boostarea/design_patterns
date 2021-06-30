package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ThreadLocal底层实现原理
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 线程唯一 {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, 线程唯一> instances = new ConcurrentHashMap<>();

    private 线程唯一() {
    }

    public static 线程唯一 getInstance() {
        long currentId = Thread.currentThread().getId();
        instances.putIfAbsent(currentId, new 线程唯一());
        return instances.get(currentId);
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
