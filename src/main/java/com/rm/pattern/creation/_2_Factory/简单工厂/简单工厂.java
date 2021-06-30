package com.rm.pattern.creation._2_Factory.简单工厂;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 简单工厂 {

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new A();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new B();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new C();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new D();
        }
        return parser;
    }


    public interface IRuleConfigParser {
    }

    public static class A implements IRuleConfigParser{

    }
    public static class B implements IRuleConfigParser{

    }
    public static class C implements IRuleConfigParser{

    }
    public static class D implements IRuleConfigParser{

    }

}
