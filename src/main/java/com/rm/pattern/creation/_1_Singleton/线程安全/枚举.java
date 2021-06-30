package com.rm.pattern.creation._1_Singleton.线程安全;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public enum 枚举 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
