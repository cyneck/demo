package com.example.demo.aop.log;

import com.alibaba.fastjson.JSON;
import com.example.demo.aop.annotation.OperationLogDetail;
import com.example.demo.aop.model.OperationLog;
import com.example.demo.model.ApiResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    /**
     * 切点是注解的方式,切点签名，表示声明了@OperationLogDetail的注解的方法，将aop生效
     * 相应的，还有@Point("execution(<匹配制定的包下的类/>)")
     */
    @Pointcut("@annotation(com.example.demo.aop.annotation.OperationLogDetail)")
    public void OperationLog() {
    }

    /**
     * 相当于直接使用上面的方法
     *
     * @param joinPoint
     */
    @Before("OperationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("进入方法前执行.....");
        /*获得 request */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("OperationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                OperationLog operationLog = new OperationLog();

                /*可以通过 joinPoint.getSignature() 获取到被通知函数的反射实例*/
                OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
                if (annotation != null) {
                    String targetName = joinPoint.getTarget().getClass().getName();
                    String methodName = joinPoint.getSignature().getName();
                    Object[] arguments = joinPoint.getArgs();   //获得参数列表
                    operationLog.setLevel(annotation.level());
                    operationLog.setDescribe(getDetail(((MethodSignature) joinPoint.getSignature()).getParameterNames(), joinPoint.getArgs(), annotation));
                    operationLog.setOperationType(annotation.operationType().getValue());
                    operationLog.setOperationTarget(annotation.operationTarget().getValue());
                }
                //TODO 保存日志
                System.out.println("记录日志:" + operationLog.toString());
            } catch (Exception e) {
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理完请求，返回内容
     *
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "OperationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("OperationLog()")
    public void throwsExcpetion(JoinPoint jp) {
        System.out.println("方法异常时执行.....");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("OperationLog()")
    public void after(JoinPoint jp) {
        System.out.println("方法最后执行.....");
    }


    /**
     * 对当前登录用户和占位符处理
     *
     * @param argNames   方法参数名称数组
     * @param args       方法参数数组
     * @param annotation 注解信息
     * @return 返回处理后的描述
     */
    private String getDetail(String[] argNames, Object[] args, OperationLogDetail annotation) {

        Map<Object, Object> map = new HashMap<>(4);
        for (int i = 0; i < argNames.length; i++) {
            map.put(argNames[i], args[i]);
        }
        String detail = annotation.detail();
        detail = "'" + "#{currentUserName}" + "'=》" + annotation.detail();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object k = entry.getKey();
            Object v = entry.getValue();
            detail = detail.replace("{{" + k + "}}", JSON.toJSONString(v));
        }
        return detail;
    }


}
