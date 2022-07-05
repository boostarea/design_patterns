package com.rm.pattern.structure.Wrapper._5_Bridge;

import java.util.List;

/**
 * 一组类与另一组类组合，独立维度扩展
 * 根据不同的告警级别，触发不同类型的告警
 * -- 通过配置动态指定对应关系
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 监控告警 {

    /**
     * 相当于抽象
     */
    public abstract class Notification {
        protected MsgSender msgSender;

        public Notification(MsgSender msgSender) {
            this.msgSender = msgSender;
        }

        public abstract void notify(String message);
    }

    public class SevereNotification extends Notification {
        public SevereNotification(MsgSender msgSender) {
            super(msgSender);
        }
        @Override
        public void notify(String message) {
            msgSender.send(message);
        }
    }

    public class UrgencyNotification extends Notification {
        public UrgencyNotification(MsgSender msgSender) {
            super(msgSender);
        }
        @Override
        public void notify(String message) {
            msgSender.send(message);
        }
    }
    public class NormalNotification extends Notification {
        public NormalNotification(MsgSender msgSender) {
            super(msgSender);
        }
        @Override
        public void notify(String message) {
            msgSender.send(message);
        }
    }
    public class TrivialNotification extends Notification {
        public TrivialNotification(MsgSender msgSender) {
            super(msgSender);
        }
        @Override
        public void notify(String message) {
            msgSender.send(message);
        }
    }

    /**
     * 相当于实现
     */
    public interface MsgSender {
        void send(String message);
    }

    public class TelephoneMsgSender implements MsgSender {
        private List<String> telephones;

        public TelephoneMsgSender(List<String> telephones) {
            this.telephones = telephones;
        }

        @Override
        public void send(String message) {
            //...
        }

    }

    public class EmailMsgSender implements MsgSender {
        @Override
        public void send(String message) {

        }
    }

    public class WechatMsgSender implements MsgSender {
        @Override
        public void send(String message) {

        }
    }
}
