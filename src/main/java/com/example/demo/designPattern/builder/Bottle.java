package com.example.demo.designPattern.builder;

/**
 * Package : com.example.demo.designPattern.builderPattern
 * Description : TODO
 * Create on : 2019/1/9 12:38 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
