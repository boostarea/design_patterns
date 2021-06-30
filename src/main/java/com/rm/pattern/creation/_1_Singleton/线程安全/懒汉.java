package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 懒汉 {
    private AtomicLong id = new AtomicLong(0);
    private static 懒汉 instance;

    private 懒汉() {
    }

    // 一把大锁
    public static synchronized 懒汉 getInstance() {
        if (instance == null) {
            instance = new 懒汉();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
