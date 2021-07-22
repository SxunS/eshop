package com.lee.eshop.common.result;

/**
 * 用于返回结果的 信息封装
 * @author admin
 */
public class CodeMessage {

    /**
     * 返回code码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 成功
     */
    public static final CodeMessage SUCCESS = new CodeMessage(200,"OK");

    /**
     * 失败
     */
    public static final CodeMessage FAILED = new CodeMessage(500, "failed");

    public CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
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
}
