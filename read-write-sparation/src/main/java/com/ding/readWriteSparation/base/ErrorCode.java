package com.ding.readWriteSparation.base;

/**
 * API 错误码
 * Created by ding on 2017/11/2.
 */
public enum ErrorCode {
    /* 用户登录异常 */
    LOGIN_USERNAME_NOT_FOUND_ERROR("用户名错误", 10000),
    LOGIN_PASSWORD_NOT_MATCH_ERROR("密码错误", 10001),
    LOGIN_ACCOUNT_LOCKED_ERROR("账户已被锁定", 10002),

    /* 登录用户相关异常 */
    BOSS_USER_DUPLICATE_LOGIN_NAME("用户名重复", 10020),
    BOSS_USER_CAN_NOT_DELETE_SELF("不可以删除自己", 10021),
    BOSS_USER_NOT_EXIST("用户不存在", 10022),
    BOSS_USER_OLDPWD_NOT_MATCH("旧密码不匹配", 10023),

    /* 角色相关异常 */
    ROLE_DUPLICATE_NAME("角色名重复", 10040),
    ROLE_CAN_NOT_DELETE_FOR_USERING("不允许删除正在使用的角色", 10042),

    /* 权限相关异常 */
    PERMISSION_DUPLICATE_PERMISSION("权限标识重复", 10060),
    PERMISSION_PARENT_NOT_EXIST("父权限不存在", 10061),
    PERMISSION_ERROR_DATA_FOR_PERMISSION("数据错误：存在重复的permission", 10062),
    PERMISSION_CNA_NOT_DELETE_USERING_PERMISSION("不允许删除正在使用中的权限", 10063),
    PERMISSION_CNA_NOT_DELETE_PARENT_PERMISSION("存在子权限，不允许删除", 10064),

    /* 部门相关异常 */
    DEPARTMENT_CAN_NOT_DELETE_FOR_HASE_CHILD("存在子部门，不允许删除", 10080),
    DEPARTMENT_CAN_NOT_DELETE_FOR_USERED("部门里有用户，不允许删除", 10081),


    /* 通用请求前置检查异常 */
    REQUEST_HEADER_ERROR("请求头错误！", 400),
    REQUEST_USER_NOT_LOGGED_IN_ERROR("当前用户尚未登录！", 401),
    
    /* 请求接口不符合条件 */
    REQUEST_INTERFACE_CHECK_DATA_ERROR("请求接口数据检查不符合条件！", 699),
    
    /* 请求接口数据不存在 */
    REQUEST_INTERFACE_DATA_UNEXISTS_ERROR("请求接口数据检查不符合条件！", 799),
    
    

    /* 正常响应 */
    OK("OK", 0),
    FILE_UPLOAD_FAILED_ERROR("FILE_UPLOAD_FAILED_ERROR", 98),
    FILE_REQ_NOT_MULTIPART_CONTENT("FILE_REQ_NOT_MULTIPART_CONTENT", 99);

    private String msg;
    private int code;

    ErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
