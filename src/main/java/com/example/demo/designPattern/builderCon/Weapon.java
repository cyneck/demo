package com.example.demo.designPattern.builderCon;

/**
 * Package : com.example.demo.designPattern.builderPattern2
 * Description : TODO
 * Create on : 2019/1/9 12:58 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public enum Weapon {
    DAGGER, SWORD, AXE, WARHAMMER, BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
