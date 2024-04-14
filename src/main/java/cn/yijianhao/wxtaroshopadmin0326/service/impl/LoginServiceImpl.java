package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Code2SessionRespDTO;
import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.auth.TokenService;
import cn.yijianhao.wxtaroshopadmin0326.config.WechatMiniPConfig;
import cn.yijianhao.wxtaroshopadmin0326.error.BusinessException;
import cn.yijianhao.wxtaroshopadmin0326.result.StatusEnum;
import cn.yijianhao.wxtaroshopadmin0326.service.IHttpService;
import cn.yijianhao.wxtaroshopadmin0326.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements ILoginService {

    private final IHttpService httpService;
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final TokenService tokenService;
    private final WechatMiniPConfig wechatMiniPConfig;

    LoginServiceImpl(IHttpService httpService, TokenService tokenService, WechatMiniPConfig wechatMiniPConfig) {
        this.httpService = httpService;
        this.tokenService = tokenService;
        this.wechatMiniPConfig = wechatMiniPConfig;
    }

    @Override
    public Token wxLogin(String code) {
        Code2SessionRespDTO respDTO = httpService.code2Session(
                wechatMiniPConfig.getAppid(),
                wechatMiniPConfig.getSecret(),
                code,
                "authorization_code"
        );
        if (respDTO.getErrcode() != 0) {
            logger.error("微信登录失败：{}, {}", respDTO.getErrcode(), respDTO.getErrmsg());
            throw new BusinessException(StatusEnum.WECHAT_ERROR, "调用微信接口时候返回码不为0");
        }
        Token token = tokenService.generateToken(respDTO.getOpenid(), respDTO.getUnionid(), respDTO.getSession_key());
        logger.debug("登录成功: " + respDTO.getOpenid());
        // todo 保存用户信息
        return token;
    }
}
