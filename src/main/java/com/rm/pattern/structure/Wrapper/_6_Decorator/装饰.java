package com.rm.pattern.structure.Wrapper._6_Decorator;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 装饰 {


    public interface 套娃接口 {
        void 套();
    }

    public static class 套娃1 implements 套娃接口 {
         @Override
        public void 套() {
            System.out.println("套娃1号");
        }
    }

    public static class 套娃2 implements 套娃接口 {
        private volatile 套娃接口 in;

        public 套娃2(套娃接口 in) {
            this.in = in;
        }
         @Override
        public void 套() {
            in.套();
            System.out.println("套娃2号");
        }
    }
    public static class 套娃3 implements 套娃接口 {
        private volatile 套娃接口 in;

        public 套娃3(套娃接口 in) {
            this.in = in;
        }
         @Override
        public void 套() {
            in.套();
            System.out.println("套娃3号");
        }
    }

    public static void main(String[] args) {
        套娃1 da1 = new 套娃1();
        套娃2 da2 = new 套娃2(da1);
        套娃3 da3 = new 套娃3(da2);
        da3.套();
    }
}
