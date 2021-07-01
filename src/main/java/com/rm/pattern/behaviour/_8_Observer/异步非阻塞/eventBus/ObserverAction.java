package com.rm.pattern.behaviour._8_Observer.异步非阻塞.eventBus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;

/**
 * 定位@Subscribe方法
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
