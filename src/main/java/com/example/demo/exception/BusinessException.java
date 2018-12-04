package com.example.demo.exception;

/**
 * Package : com.example.demo.exception
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/8 09:28 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
