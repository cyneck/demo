package com.example.demo.aopJdk;

/**
 * Package : com.example.demo.aop
 * Description : 定义切面接口，切面接口定义了两个切面方法，分别在切点接口方法执行前和执行后执行
 * Create on : 2019/1/16 16:21 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public interface IAspect {
    /**
     * 在切点接口方法执行之前执行
     *
     * @param args 切点参数列表
     * @return
     */
    boolean startTransaction(Object... args);

    /**
     * 在切点接口方法执行之后执行
     */
    void endTrasaction();
}
