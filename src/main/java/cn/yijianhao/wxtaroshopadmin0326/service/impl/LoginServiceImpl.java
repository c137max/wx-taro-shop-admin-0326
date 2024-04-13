package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Code2SessionRespDTO;
import cn.yijianhao.wxtaroshopadmin0326.config.WechatMiniPConfig;
import cn.yijianhao.wxtaroshopadmin0326.service.IHttpService;
import cn.yijianhao.wxtaroshopadmin0326.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServiceImpl implements ILoginService {

    private final IHttpService httpService;
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final WechatMiniPConfig wechatMiniPConfig;

    LoginServiceImpl(IHttpService httpService, WechatMiniPConfig wechatMiniPConfig) {
        this.httpService = httpService;
        this.wechatMiniPConfig = wechatMiniPConfig;
    }

    @Override
    public boolean wxLogin(String code) {
        Code2SessionRespDTO respDTO = httpService.code2Session(
                wechatMiniPConfig.getAppid(),
                wechatMiniPConfig.getSecret(),
                code,
                "authorization_code"
        );
        if (respDTO.getErrcode() != 0) {
            return false;
        }
        logger.debug("登录成功: " + respDTO);
        // 保存用户信息， 签发token

        return true;
    }
}
