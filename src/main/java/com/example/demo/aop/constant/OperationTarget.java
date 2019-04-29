package com.example.demo.aop.constant;

public enum OperationTarget {
    /**
     * 被操作的单元
     */
    UNKNOWN("unknown"),
    USER("table"),
    Redis("redis");

    private String value;

    OperationTarget(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
