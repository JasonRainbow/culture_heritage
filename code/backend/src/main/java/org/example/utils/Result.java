package org.example.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.common.CommonResp;
import org.example.common.ResponseStatusEnum;

import java.util.HashMap;

/**
 * 响应消息
 */
@ApiModel(value = "响应结果实体", description = "响应结果实体")
public class Result {
    @ApiModelProperty(value = "响应提示码")
    private String code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private Object data = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(CommonResp commonResp) {
        this.setCode(commonResp.getCode());
        this.setMsg(commonResp.getMsg());
    }

    public static Result success() {
        return Result.success(null);
    }

    public static Result success(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result(data);
        result.setCode(ResponseStatusEnum.SUCCESS.getCode());
        result.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResponseStatusEnum responseStatusEnum, Object data) {
        Result result = new Result(data);
        result.setCode(responseStatusEnum.getCode());
        result.setMsg(responseStatusEnum.getMsg());
        return result;
    }

    public static Result error(ResponseStatusEnum responseStatusEnum) {
        return error(responseStatusEnum, null);
    }

    // 添加数据信息 链式编程
    public Result put(String key, Object value) {
        if (this.data == null) {
            // 新建一个哈希映射，用于存储数据
            this.data = new HashMap<String, Object>();
        }
        // data不为空且不是一个HashMap的实例，则不能put
        if (!(this.data instanceof HashMap)) {
            return this;
        }
        ((HashMap<String, Object>) this.data).put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
