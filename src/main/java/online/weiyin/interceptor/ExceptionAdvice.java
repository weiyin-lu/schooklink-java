package online.weiyin.interceptor;

import cn.dev33.satoken.exception.NotLoginException;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
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
    @ExceptionHandler
    public Result<Object> exceptionHandler(Exception e){
        if(e instanceof NotLoginException) {
//            拦截所有未登录信息
            return Result.fail(ResultCode.LOGIN_ERROR2);
        } else if(e instanceof DuplicateKeyException) {
//            online.weiyin.controller.UsersController.register
//            拦截username重复
            e.printStackTrace();
            return Result.fail(ResultCode.REG_ERROR1);
        } else if(e instanceof DataIntegrityViolationException) {
//            online.weiyin.controller.UsersController.register
//            online.weiyin.controller.DictionaryController.addCode
//            拦截非空字段
            return Result.fail(ResultCode.REG_ERROR3);
        } else {
//            通用拦截其他所有未处理异常
            e.printStackTrace();
            return Result.fail(ResultCode.ERROR);
        }
    }
}
