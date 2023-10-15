package online.weiyin.common;

import lombok.Getter;

/**
 * @ClassName ResultCode
 * @Description 结果集错误码
 * @Version 1.0.0
 * @Time 2023/10/15 下午 01:01
 * @Author 卢子昂
 */
@Getter
public enum ResultCode {
//    通用码
    SUCCESS(200, "成功"),
    NOT_FOUND(404,"未找到资源"),
    ERROR(500,"服务器错误");
//    自定义码

    private Integer code;
    private String msg;
    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
