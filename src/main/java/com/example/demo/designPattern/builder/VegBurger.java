package com.example.demo.designPattern.builder;

/**
 * Package : com.example.demo.designPattern.builderPattern
 * Description : 汉堡
 * Create on : 2019/1/9 12:42 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
