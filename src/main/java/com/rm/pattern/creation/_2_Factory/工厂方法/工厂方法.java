package com.rm.pattern.creation._2_Factory.工厂方法;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/29
 **/
public class 工厂方法 {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new IllegalArgumentException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }

    public static class RuleConfig {
    }

    public interface IRuleConfigParser {
        RuleConfig parse(String text);
    }

    public static class A implements IRuleConfigParser {

        @Override
        public RuleConfig parse(String text) {
            return null;
        }
    }
    public static class B implements IRuleConfigParser {

        @Override
        public RuleConfig parse(String text) {
            return null;
        }
    }
    public static class C implements IRuleConfigParser {

        @Override
        public RuleConfig parse(String text) {
            return null;
        }
    }
    public static class D implements IRuleConfigParser {

        @Override
        public RuleConfig parse(String text) {
            return null;
        }
    }

    public interface IRuleConfigParserFactory {
        IRuleConfigParser createParser();
    }

    public static class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
        @Override
        public IRuleConfigParser createParser() {
            return new A();
        }
    }

    public static class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
        @Override
        public IRuleConfigParser createParser() {
            return new B();
        }
    }

    public static class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
        @Override
        public IRuleConfigParser createParser() {
            return new C();
        }
    }

    public static class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
        @Override
        public IRuleConfigParser createParser() {
            return new D();
        }
    }



}
