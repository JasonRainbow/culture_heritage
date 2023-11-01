package org.example.common;

public enum ResponseStatusEnum implements CommonResp{

    SUCCESS("0","请求成功!"),
    LOGIN_SUCCESS("0", "登录成功！"),
    LOGOUT_SUCCESS("0", "注销成功！"),
    ERROR("500","服务器系统错误！"),

    /** 10XX 表示用户错误*/
    USER_REGISTER_FAILED("1001", "注册失败"),
    USER_ACCOUNT_EXISTED("1002","用户名已存在"),
    USER_ACCOUNT_NOT_EXIST("1003","用户名不存在"),
    USERNAME_PASSWORD_ERROR("1004","用户名或密码错误"),
    PASSWORD_ERROR("1005","密码错误"),
    USER_ACCOUNT_EXPIRED("1006","账号过期"),
    USER_PASSWORD_EXPIRED("1007","密码过期"),
    USER_ACCOUNT_DISABLE("1008","账号不可用"),
    USER_ACCOUNT_LOCKED("1009","账号锁定"),
    USER_NOT_LOGIN("1010","用户未登陆"),
    USER_NO_PERMISSIONS("1011","用户权限不足"),
    USER_SESSION_INVALID("1012","会话已超时"),
    USER_ACCOUNT_LOGIN_IN_OTHER_PLACE("1013","账号超时或账号在另一个地方登陆，建议修改密码"),
    TOKEN_NOT_VALID("1014","非法Token，请重新登陆"),
    TOKEN_EXPIRED("1015", "token过期"),
    AUTHENTICATE_FAIL("1016", "认证失败，无法访问系统资源"),

    REQUEST_BODY_MISSING("1017", "请求数据体缺失"),
    LOGIN_NOT_ADMIN("1018", "管理员登录失败，不是管理员"),

    USERNAME_EMPTY("1019", "用户名为空"),
    PASSWORD_EMPTY("1020", "密码为空"),
    NAME_EMPTY("1021", "用户昵称为空"),


    /** 20XX 表示服务器错误 */
    PICTURE_UPLOAD_FAILED("2001","上传图片失败"),
    GIVE_LIKE_FAILED("2002","点赞失败"),
    PICTURE_LOAD_FAILED("2003","图片加载失败"),
    UPDATE_USER_INFO_FAILED("2004","修改用户信息失败"),
    UPDATE_USER_PASSWORD_FAILED("2005","修改密码失败"),
    ;

    private final String code;
    private String msg;

    ResponseStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public CommonResp setMsg(String msg) {
        this.msg=msg;
        return this;
    }
}
