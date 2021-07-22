package com.lee.eshop.common.result;

import java.io.Serializable;

/**
 * 通用返回结果集
 * @author admin
 */
public class CommonResult<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * code 码
     */
    private int code;

    /**
     * 接口返回的附加信息
     */
    private String message;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 实际返回数据
     */
    private T data;


    public CommonResult(int code, String message, boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    /**
     * 成功
     * @param data 返回实际数据
     * @return 通用格式结果
     */
    public static <T> CommonResult<T> sucess(T data){
        return new CommonResult<T>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(),true,data);
    }

    /**
     * 成功
     * @param data 返回实际数据
     * @return 通用格式结果
     */
    public static <T> CommonResult<T> sucess(CodeMessage codeMessage, T data){
        return new CommonResult<T>(codeMessage.getCode(), codeMessage.getMessage(),true,data);
    }

    /**
     * 失败
     * @param data 返回实际数据
     * @return 通用格式结果
     */
    public static <T> CommonResult<T> failed(T data){
        return new CommonResult<T>(CodeMessage.FAILED.getCode(), CodeMessage.FAILED.getMessage(),false,data);
    }

    /**
     * 失败
     * @param data 返回实际数据
     * @return 通用格式结果
     */
    public static <T> CommonResult<T> failed(CodeMessage codeMessage, T data){
        return new CommonResult<T>(codeMessage.getCode(), codeMessage.getMessage(),false,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
