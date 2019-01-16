package com.example.demo.aopCglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Package : com.example.demo.aopCglib
 * Description : 基于Cglib代理类生成器工具类
 * Create on : 2019/1/16 16:43 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class CglibProxyGenerator {

    /**
     * @param target 需要被代理的委托类对象，Cglib需要继承该类生成子类
     * @param aspect 切面对象,改对象方法将在切点方法之前或之后执行
     * @return
     */
    public static Object generatorCglibProxy(final Object target, final IAspect aspect) {
        //3.1 new Enhancer
        Enhancer enhancer = new Enhancer();
        //3.2 设置需要代理的父类
        enhancer.setSuperclass(target.getClass());
        //3.3 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                // 执行切面方法
                aspect.startTransaction();
                // 具体逻辑代码执行,返回值为方法执行结果
                Object result = methodProxy.invokeSuper(proxy, args);
                // 执行切面方法
                aspect.endTrasaction();
                // 返回方法执行结果
                return result;
            }
        });
        // 3.4 创建代理对象
        return enhancer.create();
    }


}
