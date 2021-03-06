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
public class RequestMessageModel {
    /***
     * 请求消息
     */
    private String message;
    private String userid;
    private String toUserId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}
