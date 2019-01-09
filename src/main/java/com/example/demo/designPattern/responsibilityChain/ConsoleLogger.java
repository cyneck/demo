package com.example.demo.designPattern.responsibilityChain;

/**
 * Package : com.example.demo.designPattern.responsibilityChain
 * Description : TODO
 * Create on : 2019/1/9 16:09 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
