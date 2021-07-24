package com.rm.pattern.creation._1_Singleton.线程安全.volatile探索;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/24
 **/
public class DcDemo {

    private static class Td implements Runnable {
        @Override
        public void run() {
            DCL instance = DCL.getInstance();
            if (!instance.isFlag()) {
                System.out.println("Checked");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            new Thread(new Td()).start();
        }
    }
}
