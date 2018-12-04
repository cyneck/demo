package com.example.demo.exception;

import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package : com.example.demo.exception
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/8 09:26 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ApiResponse handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        ApiResponse response = new ApiResponse();
        response.setMessage("操作失败！");
        return response;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    ApiResponse handleBusinessException(BusinessException e) {
        LOGGER.error(e.getMessage(), e);
        ApiResponse response = new ApiResponse();
        response.setMessage(e.getMessage());
        return response;
    }

}
