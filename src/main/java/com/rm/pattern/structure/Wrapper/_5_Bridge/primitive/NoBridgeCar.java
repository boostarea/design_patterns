package com.rm.pattern.structure.Wrapper._5_Bridge.primitive;

/**
 * @version 1.0
 * @since 2022/7/4
 */
public class NoBridgeCar {


    public abstract class Car {
        public abstract void run(String message);
    }

    public class BMWCar extends Car {

        @Override
        public void run(String message) {

        }
    }
    public class BenZCar extends Car {

        @Override
        public void run(String message) {

        }
    }
    public class QQCar extends Car {

        @Override
        public void run(String message) {

        }
    }


    public class BMWManualCar extends BMWCar {
        @Override
        public void run(String message) {
            super.run(message);
        }
    }

    public class BMWAutoCar extends BMWCar {
        @Override
        public void run(String message) {
            super.run(message);
        }
    }

    public class BenZManualCar extends BenZCar {
        @Override
        public void run(String message) {
            super.run(message);
        }
    }

    public class BenZAutoCar extends BenZCar {
        @Override
        public void run(String message) {
            super.run(message);
        }
    }


}
