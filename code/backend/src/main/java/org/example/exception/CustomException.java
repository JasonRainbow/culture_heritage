package org.example.exception;

import org.example.common.CommonResp;

/**
 * @author li
 */
public class CustomException extends RuntimeException implements CommonResp {

    private transient final CommonResp commonResp;

    public CustomException(CommonResp commonResp) {
        super();  // 调用父类的无参构造方法
        this.commonResp = commonResp;
    }

    @Override
    public String getMessage() {
        return this.commonResp.getMsg();
    }

    /**
     * 接收自定义msg的方式构造业务异常
     * @param msg 消息
     * @param commonResp CommonResp的实现类对象
     */
    public CustomException(String msg, CommonResp commonResp) {
        super();
        this.commonResp = commonResp;
        this.commonResp.setMsg(msg);
    }

    @Override
    public String getCode() {
        return this.commonResp.getCode();
    }

    @Override
    public String getMsg() {
        return this.commonResp.getMsg();
    }

    @Override
    public CommonResp setMsg(String msg) {
        this.commonResp.setMsg(msg);
        return this;
    }
}
