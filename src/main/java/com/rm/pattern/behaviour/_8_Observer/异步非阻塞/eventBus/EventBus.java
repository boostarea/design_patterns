package com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(final Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (final ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
