package online.weiyin.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Result
 * @Description 后端统一结果集
 * @Version 1.0.0
 * @Time 2023/10/15 下午 12:55
 * @Author 卢子昂
 */
@Getter
@Setter
@ToString
public class Result<T> {
//    对象列表
    private Integer code;
    private String msg;
    T data;
//    构造方法
    private Result() {
        this.code = 200;
        this.msg = "默认成功";
    }
    private Result(T data) {
        this.code = 200;
        this.msg = "默认成功";
        this.data = data;
    }
    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
//    返回情况
    /**
     * 返回成功，无结果集
     * @return
     * @param <T>
     */
    public static<T> Result<T> success() {
        return new Result<>();
    }
    /**
     * 返回成功，有结果集
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> success(T data) {
        return new Result<T>(data);
    }
    /**
     * 通用返回失败
     * @param resultCode
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(ResultCode resultCode) {
        return new Result<>(resultCode);
    }

}
