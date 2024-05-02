package cn.yijianhao.wxtaroshopadmin0326.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum UserType {
    WEB(2),    // 网页用户
    WE_CHART(3);  // 微信小程序用户
    private final int value;
}
