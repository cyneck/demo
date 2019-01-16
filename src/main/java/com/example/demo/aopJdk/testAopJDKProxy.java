package com.example.demo.aopJdk;

import org.junit.jupiter.api.Test;

/**
 * Package : com.example.demo.aop
 * Description : TODO
 * Create on : 2019/1/16 16:27 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class testAopJDKProxy {
    @Test
    public void testJDKProxy() throws Exception {
        System.out.println("无代理前 调用方法 userService.saveUser 输出......");
        IUserService userService = new UserServiceImpl();
        userService.saveUser("xl", "1234567890");

        System.out.println("有代理后AOP 是怎么样的？ Proxy......");
        IUserService proxyUserService = (IUserService) JDKDynamicProxyGenerator.generatorJDKProxy(userService, new CustomAspect());
        proxyUserService.saveUser("xl", "123");
        /* 制造异常,两个入参都是null  */
        proxyUserService.saveUser(null, null);
    }
}
