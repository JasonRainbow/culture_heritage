package org.example.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;
import org.example.common.ResponseStatusEnum;
import org.example.utils.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author hzx
 * 返回json
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();


    /**
     * 统一异常处理@ExceptionHandler,主要用于Exception  运行时异常
     * @param e 异常对象
     * @return 响应
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handler(RuntimeException e) {
        log.error("运行时异常：", e);
        return Result.error("-1", "后台运行异常，请联系系统管理员！");
    }

    /**
     * 其他异常
     * @param e 异常
     * @return 提示
     */
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        log.error("系统异常：", e);
        return Result.error("-1", "系统异常，请联系系统管理员！");
    }

    /**
     * 统一异常处理@ExceptionHandler,主要用于Exception  自定义异常
     * @param e 自定义异常类对象
     * @return 响应结果
     */
    @ExceptionHandler(value = CustomException.class)
    public Result handler(CustomException e) {
        log.error("发生业务异常！原因是：{}", e.getMsg());
        return Result.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result handler(HttpMessageNotReadableException exception) {
        log.log(Level.ERROR, exception.getMessage());
        return Result.error(ResponseStatusEnum.REQUEST_BODY_MISSING);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result handler(HttpRequestMethodNotSupportedException exception) {
        log.log(Level.ERROR, exception.getMessage());
        return Result.error(String.valueOf(exception.getStatusCode().value()), exception.getMessage());
    }
}
