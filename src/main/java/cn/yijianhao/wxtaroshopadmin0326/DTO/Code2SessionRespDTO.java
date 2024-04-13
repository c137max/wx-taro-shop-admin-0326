package cn.yijianhao.wxtaroshopadmin0326.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Code2SessionRespDTO {
    private String openid;
    private String session_key;
    private String unionid;
    private int errcode;  // 0 正常 40029 code 无效  45011 登录频繁 40226 高风险等级用户 -1 系统繁忙，此时请开发者稍候再试
    private String errmsg;
}
