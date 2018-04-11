package com.ding.druid.base;

/**
 * Created by ding on 2017/11/2.
 */
public class BaseResultBean extends BaseVo{
    private Integer code;   // 响应编码
    private String msg;     // 响应消息

    public BaseResultBean() {
        this.code = ErrorCode.OK.getCode();
        this.msg = ErrorCode.OK.getMsg();
    }

    public BaseResultBean(ErrorCode errCode) {
        this.code = errCode.getCode();
        this.msg = errCode.getMsg();
    }

    public BaseResultBean(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public void setErrorCode(ErrorCode errCode) {
        this.code = errCode.getCode();
        this.msg = errCode.getMsg();
    }
}
