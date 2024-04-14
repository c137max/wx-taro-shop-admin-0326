package cn.yijianhao.wxtaroshopadmin0326.system.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration
@Setter
@ConfigurationProperties(prefix = "web.interceptor")
public class WebInterceptorConfig {
    private List<String> publicUrls;

    public List<String> getPublicUrls() {
        if (publicUrls == null) {
            return Collections.emptyList();
        }
        return publicUrls;
    }
}
