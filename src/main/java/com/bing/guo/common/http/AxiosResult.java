package com.bing.guo.common.http;


import com.fasterxml.jackson.annotation.JsonInclude;


//表示这个类中在转json格式字符串时，如果存在属性为null，则这个属性不会存在json字符串中
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T> {

    private int status;

    private String message;

    private T data;

    public static <T> AxiosResult<T> success() {
        return getAxiosResult(EnumStatus.OK, null);
    }

    public static <T> AxiosResult<T> success(T data) {
        return getAxiosResult(EnumStatus.OK, data);
    }

    public static <T> AxiosResult<T> error() {
        return getAxiosResult(EnumStatus.ERROR, null);
    }

    public static <T> AxiosResult<T> error(T data) {
        return getAxiosResult(EnumStatus.ERROR, data);
    }

    public static <T> AxiosResult<T> error(EnumStatus enumStatus) {
        return getAxiosResult(EnumStatus.ERROR, null);
    }

    private static <T> AxiosResult<T> getAxiosResult(EnumStatus enumStatus, T data) {
        return new AxiosResult<T>(enumStatus, data);
    }

    private AxiosResult(EnumStatus enumStatus, T data) {
        this.status = enumStatus.getStatus();
        this.message = enumStatus.getMessage();
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
