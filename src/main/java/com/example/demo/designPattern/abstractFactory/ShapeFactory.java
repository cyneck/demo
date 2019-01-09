package com.example.demo.designPattern.abstractFactory;

import com.example.demo.designPattern.factory.Circle;
import com.example.demo.designPattern.factory.Rectangle;
import com.example.demo.designPattern.factory.Shape;
import com.example.demo.designPattern.factory.Square;

/**
 * Package : com.example.demo.designPattern.abstractFactoryPattern
 * Description : TODO
 * Create on : 2019/1/9 12:21 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
