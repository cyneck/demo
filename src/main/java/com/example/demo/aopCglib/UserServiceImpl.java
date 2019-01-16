package com.example.demo.aopCglib;

/**
 * Package : com.example.demo.aopCglib
 * Description : 业务实现类UserServiceImpl 该类 作为AOP中切点角色，切面定义的方法插入到切点的接口方法 执行前和执行后执行。
 * Create on : 2019/1/16 16:42 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class UserServiceImpl {
    public void saveUser(String username, String password) {
        System.out.println("cglib save user[username=" + username + ",password=" + password + "]");
    }
}
