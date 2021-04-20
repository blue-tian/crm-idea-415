package com.bing.guo.common.http;

public enum EnumStatus {
    OK(20000,"操作成功"),
    ERROR(30000,"操作失败"),
    UPDATE_ERROR(40000,"修改数据失败");
    private int status;
    private String message;
    EnumStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
