package com.example.demo.designPattern.proxyDynamicJdk;

/**
 * Package : com.example.demo.designPattern.proxyDynamic
 * Description : TODO
 * Create on : 2019/1/16 15:18 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class SoftwareEngineer implements Person {
    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void goWorking(String name, String dst) {
        System.out.println("name =" + name + " ， 去 " + dst + " 工作");
    }
}
