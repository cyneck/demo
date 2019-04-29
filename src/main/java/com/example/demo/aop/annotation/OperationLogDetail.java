package com.example.demo.aop.annotation;

import com.example.demo.aop.constant.OperationTarget;
import com.example.demo.aop.constant.OperationType;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLogDetail {

    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "";

    /**
     * 日志等级:自己定，此处分为1-5
     */
    int level() default 0;

    /**
     * 操作类型(enum):主要是select,insert,update,delete
     */
    OperationType operationType() default OperationType.UNKNOWN;

    /**
     * 被操作的对象(此处使用enum):可以是任何对象，如表名(user)，或者是工具(redis)
     */
    OperationTarget operationTarget() default OperationTarget.UNKNOWN;
}
