package com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus.used;


import com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus.Subscribe;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class StringObserver {

    @Subscribe
    public void b(String userId) {
        System.out.println("StringObserver b user_id:" + userId);
    }
}
