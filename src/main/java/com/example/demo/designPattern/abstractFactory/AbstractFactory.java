package com.example.demo.designPattern.abstractFactory;

import com.example.demo.designPattern.factory.Shape;

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
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
