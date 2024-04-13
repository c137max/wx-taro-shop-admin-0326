package cn.yijianhao.wxtaroshopadmin0326.controller.VO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Code2SessionVO {
    private String openid;

    private String sessionKey;
    @NotBlank(message = "登录代码不能为空")

    private String code;
}
