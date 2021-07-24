package com.rm.pattern.creation._1_Singleton.线程安全.volatile探索;


/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/24
 **/
public class DCL {

    private static DCL instance;
    private volatile boolean flag = false;

    private DCL() {
        try {
            Thread.sleep(1000);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public static DCL getInstance() {
        if (null == instance) {
            synchronized (DCL.class) {
                if (null == instance) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
