package cn.yijianhao.wxtaroshopadmin0326.system;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.system.auth.TokenService;
import cn.yijianhao.wxtaroshopadmin0326.system.config.WebInterceptorConfig;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Results;
import cn.yijianhao.wxtaroshopadmin0326.system.result.StatusEnum;
import cn.yijianhao.wxtaroshopadmin0326.utils.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.List;

public class GlobalInterceptor implements HandlerInterceptor {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final WebInterceptorConfig webInterceptorConfig;
    private final TokenService tokenService;

    public GlobalInterceptor(WebInterceptorConfig webInterceptorConfig, TokenService tokenService) {
        this.webInterceptorConfig = webInterceptorConfig;
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        // 在请求处理之前执行的逻辑
        // 返回 true 表示继续处理，返回 false 表示终止请求
        String requestPath = request.getRequestURI();
        List<String> allowedRoutes = webInterceptorConfig.getPublicUrls();

        // 判断是否为放行路由
        for (String route : allowedRoutes) {
            if (pathMatcher.match(route, requestPath)) {
                return true; // 放行
            }
        }
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String accessToken = token.substring(7); // 跳过 "Bearer " 前缀获取实际的 Token 值
            Token token1 = tokenService.getToken(accessToken);
            if (token1 != null) {
                buildUserContext(token1);
                return true;
            }
        }
        writeFailResponse(response, StatusEnum.NOT_AUTHORIZED);
        return false;
    }

    private void writeFailResponse(HttpServletResponse response, StatusEnum statusEnum) throws Exception {
        Response<String> failResp = Results.fail(StatusEnum.NOT_AUTHORIZED);
        response.setContentType("application/json;charset=utf-8");
        String jsonResponse = JsonUtil.objectToJson(failResp);
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
        writer.close();
    }

    private void buildUserContext(Token token) {
        UserContext.setUserInfo(token);
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理之后
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        // 请求处理完成后
    }
}
