package com.example.demo.designPattern.proxyDynamicJdk;

/**
 * Package : com.example.demo.designPattern.proxyDynamic
 * Description : 公共接口
 * Create on : 2019/1/16 15:16 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public interface Person {

    /* *
     *@param name 人名
     * @param dst 工作目的地
     */
    void goWorking(String name, String dst);

    /**
     * 获取名称
     *
     * @return
     */
    String getName();

    /**
     * 设置名称
     *
     * @param name
     */
    void setName(String name);
}
