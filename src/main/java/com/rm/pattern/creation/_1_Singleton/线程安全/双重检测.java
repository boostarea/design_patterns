package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 双重检测 {

    private AtomicLong id = new AtomicLong(0);

    // 对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序
    private static 双重检测 instance;

    private 双重检测() {
    }

    public static 双重检测 getInstance() {
        if (instance == null) {
            synchronized (双重检测.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new 双重检测();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
