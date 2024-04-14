package cn.yijianhao.wxtaroshopadmin0326.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    private String accessToken;
    private Date expiresIn;
    private String unionid;
    private String openid;
    private String sessionKey;
}
