package com.example.demo.designPattern.builder;

/**
 * Package : com.example.demo.designPattern.builderPattern
 * Description : 可口可乐
 * Create on : 2019/1/9 12:46 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
