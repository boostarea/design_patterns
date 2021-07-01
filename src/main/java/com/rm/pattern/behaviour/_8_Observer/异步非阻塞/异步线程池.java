package com.rm.pattern.behaviour._8_Observer.异步非阻塞;

import com.rm.pattern.behaviour._8_Observer.同步阻塞;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/1
 **/
public class 异步线程池 {
    private static Executor executor;

    public 异步线程池(Executor executor) {
        this.executor = executor;
    }

    public static class ConcreteSubject implements 同步阻塞.Subject {
        private List<同步阻塞.Observer> observers = new ArrayList<同步阻塞.Observer>();

        @Override
        public void registerObserver(同步阻塞.Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(同步阻塞.Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(final 同步阻塞.Message message) {
            for (final 同步阻塞.Observer observer : observers) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        observer.update(message);
                    }
                });
            }
        }

    }

    public static class ConcreteObserverOne implements 同步阻塞.Observer {
        @Override
        public void update(同步阻塞.Message message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverOne is notified.");
        }
    }

    public static class ConcreteObserverTwo implements 同步阻塞.Observer {
        @Override
        public void update(同步阻塞.Message message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverTwo is notified.");
        }
    }

    public static void main(String[] args) {
        同步阻塞.ConcreteSubject subject = new 同步阻塞.ConcreteSubject();
        subject.registerObserver(new 同步阻塞.ConcreteObserverOne());
        subject.registerObserver(new 同步阻塞.ConcreteObserverTwo());
        subject.notifyObservers(new 同步阻塞.Message());
    }
}
