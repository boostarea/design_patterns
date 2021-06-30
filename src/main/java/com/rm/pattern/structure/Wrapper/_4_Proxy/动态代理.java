package com.rm.pattern.structure.Wrapper._4_Proxy;

import com.rm.pattern.structure.Wrapper._4_Proxy.静态代理.实现相同接口;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 动态代理 {

    public class MetricsCollectorProxy {
        private 实现相同接口.MetricsCollector metricsCollector;

        public MetricsCollectorProxy() {
            this.metricsCollector = new 实现相同接口.MetricsCollector();
        }

        public Object createProxy(Object proxiedObject) {
            Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
            DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
            return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
        }

        private class DynamicProxyHandler implements InvocationHandler {
            private Object proxiedObject;

            public DynamicProxyHandler(Object proxiedObject) {
                this.proxiedObject = proxiedObject;
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long startTimestamp = System.currentTimeMillis();
                Object result = method.invoke(proxiedObject, args);
                long endTimeStamp = System.currentTimeMillis();
                long responseTime = endTimeStamp - startTimestamp;
                String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
                实现相同接口.RequestInfo requestInfo = new 实现相同接口.RequestInfo(apiName, responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
                return result;
            }
        }
    }

    //MetricsCollectorProxy使用举例
    MetricsCollectorProxy proxy = new MetricsCollectorProxy();
    实现相同接口.IUserController userController = (实现相同接口.IUserController) proxy.createProxy(new 实现相同接口.UserController());
}
