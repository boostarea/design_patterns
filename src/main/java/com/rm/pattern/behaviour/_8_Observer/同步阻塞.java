package com.rm.pattern.behaviour._8_Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/1
 **/
public class 同步阻塞 {

    public interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers(Message message);
    }

    public interface Observer {
        void update(Message message);
    }

    public static class Message {
    }

    public static class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<Observer>();

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(Message message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

    }

    public static class ConcreteObserverOne implements Observer {
        @Override
        public void update(Message message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverOne is notified.");
        }
    }

    public static class ConcreteObserverTwo implements Observer {
        @Override
        public void update(Message message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverTwo is notified.");
        }
    }

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}
