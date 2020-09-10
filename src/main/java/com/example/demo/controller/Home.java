package com.example.demo.controller;

import com.example.demo.aop.annotation.OperationLogDetail;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/7/12 14:38 星期四
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/

@Api(value = "Home", description = "RESTful API")
@RestController
@RequestMapping(value = "/home/*")
public class Home {

    @Autowired
    private PersonService personService;

    @OperationLogDetail
    @Valid
    @ApiOperation(value = "index", notes = "简单SpringMVC请求")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam(name = "id", required = false) @NotBlank(message = "id不能为空") String id) {
        Person person = new Person(1, "lxl", "man", 18);
        personService.update(person);
        return id;
    }

    @Valid
    @ApiOperation(value = "myIndex", notes = "简单SpringMVC请求")
    @RequestMapping(value = "myIndex", method = RequestMethod.GET)
    public String myIndex(@RequestParam(name = "id", required = false) @NonNull Integer id) {
        return id.toString();
    }

    @ApiOperation(value = "test", notes = "简单SpringMVC请求")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(@RequestBody @Valid Person person) {
        return "aa";
    }
}
