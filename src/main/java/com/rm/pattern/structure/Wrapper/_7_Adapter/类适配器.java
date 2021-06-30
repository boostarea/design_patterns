package com.rm.pattern.structure.Wrapper._7_Adapter;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 类适配器 {

    // 类适配器: 基于继承
    public interface ITarget {
        void f1();
        void f2();
        void fc();
    }

    public class Adaptee {
        public void fa() { }
        public void fb() { }
        public void fc() { }
    }

    public class Adaptor extends Adaptee implements ITarget {
        public void f1() {
            super.fa();
        }

        public void f2() {
            //...重新实现f2()...
        }

        // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
    }

}



