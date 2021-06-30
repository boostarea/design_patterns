package com.rm.pattern.creation._2_Factory.简单工厂;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 单例模式结合简单工厂 {
    private static final Map<String, 简单工厂.IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new 简单工厂.A());
        cachedParsers.put("xml", new 简单工厂.B());
        cachedParsers.put("yaml", new 简单工厂.C());
        cachedParsers.put("properties", new 简单工厂.D());
    }

    public static 简单工厂.IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        简单工厂.IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
