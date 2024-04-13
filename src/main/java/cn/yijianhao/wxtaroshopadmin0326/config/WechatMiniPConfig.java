package cn.yijianhao.wxtaroshopadmin0326.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "wechat.miniapp")
@Configuration
@Getter
@Setter
public class WechatMiniPConfig {
    private String appid;
    private String secret;

    @Override
    public String toString() {
        return "WechatMiniPConfig{" +
                "appid='" + appid + '\'' +
                ", secret='" + hideSecret(secret) + '\'' +
                '}';
    }

    private String hideSecret(String secret) {
        if (secret.length() >= 6) {
            String start = secret.substring(0, 3);
            String end = secret.substring(secret.length() - 3);
            return start + "***" + end;
        } else {
            return secret;
        }
    }
}
