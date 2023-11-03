package org.example.common;

/**
 * @author hzx
 * 返回对象的接口，装饰者模式
 */
public interface CommonResp {
    /**
     * 获取响应码
     * @return 响应码
     */
    String getCode();

    /**
     * 获取消息
     * @return 消息
     */
    String getMsg();

    /**
     * 设置消息
     * @param msg 要设置的消息
     * @return CommonResp实现类对象
     */
    CommonResp setMsg(String msg);
}
