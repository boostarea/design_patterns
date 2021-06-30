package com.rm.pattern.creation._2_Factory.工厂方法;

import java.util.HashMap;
import java.util.Map;

/**
 * 不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 工厂方法嵌套简单工厂 {

    public class RuleConfigSource {
        public 工厂方法.RuleConfig load(String ruleConfigFilePath) {
            String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

            工厂方法.IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
            if (parserFactory == null) {
                throw new IllegalArgumentException("Rule config file format is not supported: " + ruleConfigFilePath);
            }
            工厂方法.IRuleConfigParser parser = parserFactory.createParser();

            String configText = "";
            //从ruleConfigFilePath文件中读取配置文本到configText中
            工厂方法.RuleConfig ruleConfig = parser.parse(configText);
            return ruleConfig;
        }

        private String getFileExtension(String filePath) {
            //...解析文件名获取扩展名，比如rule.json，返回json
            return "json";
        }
    }

    //因为工厂类只包含方法，不包含成员变量，完全可以复用，
    //不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
    public static class RuleConfigParserFactoryMap { //工厂的工厂
        private static final Map<String, 工厂方法.IRuleConfigParserFactory> cachedFactories = new HashMap<>();

        static {
            cachedFactories.put("json", new 工厂方法.JsonRuleConfigParserFactory());
            cachedFactories.put("xml", new 工厂方法.XmlRuleConfigParserFactory());
            cachedFactories.put("yaml", new 工厂方法.YamlRuleConfigParserFactory());
            cachedFactories.put("properties", new 工厂方法.PropertiesRuleConfigParserFactory());
        }

        public static 工厂方法.IRuleConfigParserFactory getParserFactory(String type) {
            if (type == null || type.isEmpty()) {
                return null;
            }
            工厂方法.IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
            return parserFactory;
        }
    }


}


