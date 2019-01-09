package com.example.demo.designPattern.bridge;

/**
 * Package : com.example.demo.designPattern.bridge
 * Description : 抽象桥接类
 * Create on : 2019/1/9 13:34 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}