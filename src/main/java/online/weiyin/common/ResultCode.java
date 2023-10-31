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
    NOT_FOUND(404,"未找到资源"),
    ERROR(500,"服务器错误"),
//    自定义码-登录和鉴权
    CHECK_ERROR1(1001, "登录失败，账号或密码错误"),
    CHECK_ERROR2(1002, "未登录或登录已过期"),
    CHECK_ERROR3(1003, "注册失败，账号已存在"),
    CHECK_ERROR4(1004, "注册失败，无效角色"),
    CHECK_ERROR5(1005,"角色权限不足"),
//    自定义码-业务相关
    INSERT_ERROR1(2001,"插入失败，请联系系统管理员"),
    INSERT_ERROR2(2002,"缺少必填字段"),
    UPDATE_ERROR1(2003,"更新失败，请联系系统管理员"),
    UPDATE_ERROR2(2004,"更新失败，无有效数据"),
    ;

    private Integer code;
    private String msg;
    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
