package com.example.demo.model;

/**
 * Package : com.example.demo.model
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/30 20:03 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class ResponseMessageModel {

    public ResponseMessageModel(String message) {
        this.message = message;
    }

    /**
     * 响应消息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
