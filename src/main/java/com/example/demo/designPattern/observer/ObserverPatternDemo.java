package com.example.demo.designPattern.observer;

/**
 * Package : com.example.demo.designPattern.observer
 * Description : TODO
 * Create on : 2019/1/9 14:47 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();//

        //绑定观察者和主体，可以理解为观察者订阅subject
        HexObserver hexObserver = new HexObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        BinaryObserver binaryObserver = new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}