package com.example.demo.designPattern.observer;

/**
 * Package : com.example.demo.designPattern.observer
 * Description : 十六进制观察员
 * Create on : 2019/1/9 14:46 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);//实现绑定观察者和subject之间的绑定
    }

    @Override
    public void update() {
        System.out.println("HexObserver state: "
                + subject.getState());
    }
}
