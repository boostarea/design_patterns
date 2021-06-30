package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 静态内部类 {

    private AtomicLong id = new AtomicLong(0);

    private 静态内部类() {
    }

    private static class SingletonHolder {
        private static final 静态内部类 instance = new 静态内部类();
    }

    public static 静态内部类 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
