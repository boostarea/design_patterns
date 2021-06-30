package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 饿汉 {
    private AtomicLong id = new AtomicLong(0);
    private static final 饿汉 instance = new 饿汉();

    private 饿汉() {
    }

    public static 饿汉 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
