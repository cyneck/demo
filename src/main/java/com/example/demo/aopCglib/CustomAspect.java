package com.example.demo.aopCglib;

/**
 * Package : com.example.demo.aopCglib
 * Description : TODO
 * Create on : 2019/1/16 16:41 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class CustomAspect implements IAspect {
    @Override
    public void startTransaction() {
        System.out.println("cglib. I get datasource here and start transaction");
    }

    public void endTrasaction() {
        System.out.println("cglib I get datasource here and end transaction");
    }
}
