package com.example.demo.designPattern.abstractFactory;

/**
 * Package : com.example.demo.designPattern.abstractFactoryPattern
 * Description : TODO
 * Create on : 2019/1/9 12:20 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class GreenColor implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
