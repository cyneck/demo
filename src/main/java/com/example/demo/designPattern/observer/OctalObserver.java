package com.example.demo.designPattern.observer;

/**
 * Package : com.example.demo.designPattern.observer
 * Description : 八进制观察员
 * Create on : 2019/1/9 14:46 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver state: "
                + subject.getState());
    }
}