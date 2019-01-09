package com.example.demo.designPattern.builder;

/**
 * Package : com.example.demo.designPattern.builderPattern
 * Description : 食物条目和食物包装的接口。
 * Create on : 2019/1/9 12:37 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
