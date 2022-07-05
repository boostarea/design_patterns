package com.rm.pattern.structure.Wrapper._6_Decorator.troll;

/**
 * 精妙实现，通过抽象类的复用属性 -》 放置待装饰类成员 -》 提供所有方法默认实现 -》 继承他的实现类，若无增强功能，则可不重载方法
 * @version 1.0
 * @since 2022/7/4
 */
public abstract class FilterTroll implements Troll {

    protected volatile Troll decorated;

    protected FilterTroll(Troll troll) {
        this.decorated = troll;
    }

    @Override
    public void attack() {
        decorated.attack();
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower();
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
