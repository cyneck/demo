package com.example.demo.designPattern.observer;

/**
 * Package : com.example.demo.designPattern.observer
 * Description : TODO
 * Create on : 2019/1/9 14:44 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public abstract class Observer {
    //各个继承的观察者共享subject对象的数据
    //Subject和Observer在内部实现互相引用
    protected Subject subject;

    public abstract void update();
}
