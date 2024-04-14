package cn.yijianhao.wxtaroshopadmin0326.system.config;

import cn.yijianhao.wxtaroshopadmin0326.system.GlobalInterceptor;
import cn.yijianhao.wxtaroshopadmin0326.system.auth.TokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    private final WebInterceptorConfig webInterceptorConfig;
    private final TokenService tokenService;
    public WebConfig(WebInterceptorConfig appConfig, TokenService tokenService) {
        this.webInterceptorConfig = appConfig;
        this.tokenService = tokenService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalInterceptor(webInterceptorConfig, tokenService));
    }
}
