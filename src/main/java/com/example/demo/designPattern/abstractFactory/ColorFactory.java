package com.example.demo.designPattern.abstractFactory;

import com.example.demo.designPattern.factory.Shape;

/**
 * Package : com.example.demo.designPattern.abstractFactoryPattern
 * Description : TODO
 * Create on : 2019/1/9 12:23 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new RedColor();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new GreenColor();
        }
        return null;
    }
}
