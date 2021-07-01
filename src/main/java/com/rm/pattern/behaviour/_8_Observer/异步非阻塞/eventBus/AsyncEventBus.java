package com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus;

import java.util.concurrent.Executor;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
