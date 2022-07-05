package com.rm.pattern.structure.Wrapper._4_Proxy.静态代理;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 继承方式 {

    public class UserControllerProxy extends 实现相同接口.UserController {
        private 实现相同接口.MetricsCollector metricsCollector;

        public UserControllerProxy() {
            this.metricsCollector = new 实现相同接口.MetricsCollector();
        }


        public 实现相同接口.UserVo login(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            //super调用是关键
            实现相同接口.UserVo userVo = super.login(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            实现相同接口.RequestInfo requestInfo = new 实现相同接口.RequestInfo("login", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }

        public 实现相同接口.UserVo register(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            实现相同接口.UserVo userVo = super.register(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            实现相同接口.RequestInfo requestInfo = new 实现相同接口.RequestInfo("register", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }
    }
    //UserControllerProxy使用举例
    // UserController userController = new UserControllerProxy();
}
