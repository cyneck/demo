package com.example.demo.controller;

import com.example.demo.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/22 11:25 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Api(value = "Index", description = "RESTful API")
@RestController
@RequestMapping(value = "/index/*")
public class Index extends AuthController {
    @ApiOperation(value = "", notes = "简单SpringMVC请求")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String index() {
        throw new NullPointerException();
    }
}
