package com.example.demo.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

/**
 * Package : com.example.demo.model
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/9 08:59 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Getter
@Setter
public class ApiResponse {
    private String code;
    private String message;
    private String state;

}
