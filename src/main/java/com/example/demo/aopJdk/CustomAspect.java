package com.example.demo.aopJdk;

import java.util.Objects;

/**
 * Package : com.example.demo.aop
 * Description : TODO
 * Create on : 2019/1/16 16:23 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class CustomAspect implements IAspect {
    /**
     * 对参数 做判空处理
     *
     * @param args 切点参数列表
     * @return
     */
    @Override
    public boolean startTransaction(Object... args) {
        Objects.nonNull(args);
        boolean result = true;
        for (Object temp : args) {
            if (Objects.isNull(temp)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void endTrasaction() {
        System.out.println("I get datasource here and end transaction");
    }
}
