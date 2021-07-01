package com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus.used;

import com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus.AsyncEventBus;
import com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class TestController {

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 1;

    public TestController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(Long userId) {
        System.out.println("register user_id: " + userId);
        eventBus.post(userId);
        return userId;
    }

    public static void main(String[] args) throws InterruptedException {
        TestController tc = new TestController();
        ArrayList<Object> observers = new ArrayList<>();
        observers.add(new LongObserver());
        observers.add(new StringObserver());
        tc.setObservers(observers);
        tc.register(12345L);
    }
}
