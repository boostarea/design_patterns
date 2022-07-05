package com.rm.pattern.structure.Wrapper._6_Decorator.primitive;

/**
 * 无限继承流
 * <p>继承层次过深、继承关系过于复杂会影响到代码的可读性和可维护性</p>
 * @version 1.0
 * @since 2022/7/4
 */
public class NoDecoratorCar {

    public interface Car {
        void run();
    }

    public class IronCar implements Car {
        @Override
        public void run() {
        }
    }

    public class DieselIronCar extends IronCar {
        @Override
        public void run() {
        }
    }


    public class RoadsterDieselIronCar extends DieselIronCar {
        @Override
        public void run() {
        }
    }

    // ...
}
