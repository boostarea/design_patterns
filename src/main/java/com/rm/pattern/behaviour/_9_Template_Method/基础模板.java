package com.rm.pattern.behaviour._9_Template_Method;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/1
 **/
public class 基础模板 {

    public abstract class AbstractClass {
        public final void templateMethod() {
            //...
            method1();
            //...
            method2();
            //...
        }
        protected abstract void method1();
        protected abstract void method2();
    }

    public class ConcreteClass1 extends AbstractClass {
        @Override
        protected void method1() {
            //...
        }

        @Override
        protected void method2() {
            //...
        }
    }

    public class ConcreteClass2 extends AbstractClass {
        @Override
        protected void method1() {
            //...
        }

        @Override
        protected void method2() {
            //...
        }
    }

    public void main(String[] args) {
        AbstractClass demo = new ConcreteClass1();
        demo.templateMethod();
    }
}
