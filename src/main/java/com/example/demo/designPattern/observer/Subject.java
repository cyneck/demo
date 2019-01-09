package com.example.demo.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Package : com.example.demo.designPattern.observer
 * Description : 包含有各个观察者的主体
 * Create on : 2019/1/9 14:44 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Subject {
    //Subject和Observer在内部实现互相引用
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    //绑定观察者到 Client 对象和从 Client 对象解绑观察者的方法,在observers集合中附加对象
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //广播通知
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            //遍历更新
            observer.update();
        }
    }
}
