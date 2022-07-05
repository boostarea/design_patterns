package com.rm.pattern.structure.Wrapper._5_Bridge.weapon;

/**
 * @version 1.0
 * @since 2022/7/4
 */
public abstract class AbstractWeapon implements Weapon {

    /**
     * 驱动类定义在抽象类，设为protected，避免实现类重复定义
     * <p>抽象类protected定义，子类重复使用<p/>
     */
    protected Enchantment enchantment;

    protected AbstractWeapon(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
