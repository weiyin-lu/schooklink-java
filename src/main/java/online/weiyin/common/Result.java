package online.weiyin.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "业务结果集", description = "用于业务接口返回")
public class Result<T> {
//    对象列表
    @ApiModelProperty("编码，除http标准编码外包含自定义码")
    private Integer code;
    @ApiModelProperty("消息，具有良好交互的返回信息")
    private String msg;
    @ApiModelProperty("数据，携带返回值的接口会有此信息")
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
    private Result(String msg) {
        this.code = 200;
        this.msg = msg;
    }
    private Result(String msg,T data) {
        this.code = 200;
        this.msg = msg;
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
     * 返回成功，自定义文本
     * @return
     * @param <T>
     */
    public static<T> Result<T> success(String msg) {
        return new Result<>(msg);
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
     * 返回成功，自定义文本，有结果集
     * @param msg
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> success(String msg,T data) {
        return new Result<T>(msg, data);
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
