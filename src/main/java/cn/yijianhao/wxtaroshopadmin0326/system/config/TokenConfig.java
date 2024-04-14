package cn.yijianhao.wxtaroshopadmin0326.system.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "token")
@Configuration
@Getter
@Setter
public class TokenConfig {
    private int expSecond = 60 * 60 * 24;
}
