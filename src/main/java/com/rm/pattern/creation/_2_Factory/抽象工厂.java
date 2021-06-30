package com.rm.pattern.creation._2_Factory;

/**
 * 同类型整合，有效地减少工厂类的个数
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 抽象工厂 {

    public interface IConfigParserFactory {
        IRuleConfigParser createRuleParser();
        ISystemConfigParser createSystemParser();
        //此处可以扩展新的parser类型，比如IBizConfigParser
    }

    public class JsonConfigParserFactory implements IConfigParserFactory {
        @Override
        public IRuleConfigParser createRuleParser() {
            return new JsonRuleConfigParser();
        }

        @Override
        public ISystemConfigParser createSystemParser() {
            return new JsonSystemConfigParser();
        }
    }

    public class XmlConfigParserFactory implements IConfigParserFactory {
        @Override
        public IRuleConfigParser createRuleParser() {
            return new XmlRuleConfigParser();
        }

        @Override
        public ISystemConfigParser createSystemParser() {
            return new XmlSystemConfigParser();
        }
    }


    public interface IRuleConfigParser {
    }
    public interface ISystemConfigParser {
    }

    public static class JsonRuleConfigParser implements IRuleConfigParser {
    }
    public static class JsonSystemConfigParser implements ISystemConfigParser {
    }
    public static class XmlRuleConfigParser implements IRuleConfigParser {
    }
    public static class XmlSystemConfigParser implements ISystemConfigParser {
    }

}
