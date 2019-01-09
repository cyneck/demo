package com.example.demo.designPattern.builderCon;

/**
 * Package : com.example.demo.designPattern.builderPattern2
 * Description : TODO
 * Create on : 2019/1/9 12:57 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Hero {
    private String name;
    private Profession profession;
    private HairColor hairColor;
    private Weapon weapon;

    public Hero(HeroBuilder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.hairColor = builder.hairColor;
        this.weapon = builder.weapon;
    }


    //建造者静态类
    public static class HeroBuilder {
        private Profession profession;
        private String name;
        private HairColor hairColor;
        private Weapon weapon;

        public HeroBuilder(Profession profession, String name) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public HeroBuilder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public HeroBuilder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
