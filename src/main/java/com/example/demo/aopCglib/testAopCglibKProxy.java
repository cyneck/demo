package com.example.demo.aopCglib;

import org.junit.jupiter.api.Test;

/**
 * Package : com.example.demo.aopCglib
 * Description : TODO
 * Create on : 2019/1/16 16:44 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class testAopCglibKProxy {
    @Test
    public void testCglibProxy() {
        System.out.println("before Proxy......");
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("xl", "123");

        System.out.println("引入Cglib  Proxy代理库 后......");
        UserServiceImpl proxyUserService = (UserServiceImpl) CglibProxyGenerator.generatorCglibProxy(userService, new CustomAspect());
        proxyUserService.saveUser("xl", "1245");
    }
}
