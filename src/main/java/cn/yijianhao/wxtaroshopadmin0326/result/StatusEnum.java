package cn.yijianhao.wxtaroshopadmin0326.result;

import lombok.Getter;

@Getter
public enum StatusEnum {
    SUCCESS(0, ""),
    FAIL(3000, "业务处理失败");

    private final int code;
    private final String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
