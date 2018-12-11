package com.ten.air.back.model;

/**
 * [状态码, 状态信息]
 */
public enum ResponseCode {
    /**
     * @param 0 success
     * @param 100 failure
     */
    OK(0, "成功"),
    ERROR(100, "失败");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
