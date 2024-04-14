package cn.yijianhao.wxtaroshopadmin0326.result;

import lombok.Getter;

@Getter
public enum StatusEnum {
    SUCCESS(0, ""),
    FAIL(3000, "请求处理失败，请稍后重试"),
    WECHAT_ERROR(3001, "请求失败，请稍后重试"),  // 与微信相关的错误
    SERVER_ERROR(5000, "服务器错误，工程师正在紧急修复中"),
    PARAM_ERROR(3002, "参数错误"),
    NOT_FOUND(3003, "资源不存在"),
    NOT_AUTHORIZED(3004, "请先登录"),
    NOT_LOGGED_IN(3005, "无权限"),
    ;

    private final int code;
    private final String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
