package cn.yijianhao.wxtaroshopadmin0326.controller.VO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Code2SessionRepVO {
    private String unionid;
    private String openid;
    private String token;
}
