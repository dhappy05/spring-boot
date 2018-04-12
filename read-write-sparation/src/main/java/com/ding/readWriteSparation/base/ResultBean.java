package com.ding.readWriteSparation.base;

/**
 * Created by ding on 2017/11/2.
 */
public class ResultBean extends BaseResultBean {
    private Object data;

    public ResultBean success() {
        super.setErrorCode(ErrorCode.OK);
        return this;
    }

    public ResultBean success(Object data) {
        super.setErrorCode(ErrorCode.OK);
        this.setData(data);
        return this;
    }

    public ResultBean failure(ErrorCode code) {
        this.setErrorCode(code);
        return this;
    }

    public ResultBean failure(ErrorCode code, String msg) {
        this.setErrorCode(code);
        this.setMsg(msg);
        return this;
    }

    /**
     * 由于业务代码中有时需要返回具体的错误消息给前端显示，故添加本方法
     * @param code
     * @param message
     * @return
     */
    public ResultBean failure(Integer code, String message) {
        this.setCode(code);
        this.setMsg(message);
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
