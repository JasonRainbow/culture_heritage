package org.example.common;

/**
 * 返回对象的接口，装饰者模式
 */
public interface CommonResp {
    String getCode(); // 获取响应码

    String getMsg(); // 获取消息

    CommonResp setMsg(String msg); // 设置消息
}
