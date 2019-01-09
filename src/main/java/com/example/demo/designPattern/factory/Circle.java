package com.example.demo.designPattern.factory;

/**
 * Package : com.example.demo.designPattern.factoryPattern
 * Description : TODO
 * Create on : 2019/1/9 11:51 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
