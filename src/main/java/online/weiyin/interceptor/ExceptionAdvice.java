package online.weiyin.interceptor;

import cn.dev33.satoken.exception.NotLoginException;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ExceptionAdvice
 * @Description 全局异常拦截
 * @Version 1.0.0
 * @Time 2023/10/15 下午 03:35
 * @Author 卢子昂
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<Object> exceptionHandler(Exception e){
        if(e instanceof NotLoginException) {
            return Result.fail(ResultCode.LOGIN_OUT_ERROR);
        } else {
            return Result.success();
        }
    }
}
