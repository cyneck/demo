package com.example.demo.designPattern.builderCon;

/**
 * Package : com.example.demo.designPattern.builderPattern2
 * Description : TODO
 * Create on : 2019/1/9 13:03 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class builderDemo {
    public static void main(String[] args) {
        Hero mage = new Hero.HeroBuilder(Profession.MAGE, "Riobard")
                .withHairColor(HairColor.BLACK)
                .withWeapon(Weapon.DAGGER).build();
        System.out.println(mage);
    }
}
