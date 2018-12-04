package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/22 11:19 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public abstract class BaseController {
    // 日志对象
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public String getUser() {
        return "baseUser";
    }

    public String getUserId(){
        return "baseUserId";
    }

    @ExceptionHandler
    @ResponseBody
    public Object exception(Exception ex) {
        //记录下日志
        LOGGER.error(ex.getMessage(), ex);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("msg");
        return apiResponse;
    }
}
