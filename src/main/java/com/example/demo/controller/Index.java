package com.example.demo.controller;

import com.example.demo.auth.JwtUtil;
import com.example.demo.rabbitMQ.AmqpComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

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


    @ApiOperation(value = "", notes = "消息队列测试")
    @RequestMapping(value = "mqTest", method = RequestMethod.GET)
    public void mqTest() {

    }

    @ApiOperation(value = "", notes = "login")
    @PostMapping("/login")
    public Object login(HttpServletResponse response,
                        @RequestBody Account account) {
        if (isValidPassword(account)) {
            String jwt = JwtUtil.generateToken(account.username);
            return new HashMap<String, String>() {{
                put("token", jwt);
            }};
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public @ResponseBody
    Object helloToAdmin(String userId) {
        return "Hello World! You are ADMIN ";
    }

    private boolean isValidPassword(Account ac) {
        //we just have 2 hardcoded user
        if ("admin".equals(ac.username) && "admin".equals(ac.password)
                || "user".equals(ac.username) && "user".equals(ac.password)) {
            return true;
        }
        return false;
    }


    public static class Account {
        public String username;
        public String password;
    }
}
