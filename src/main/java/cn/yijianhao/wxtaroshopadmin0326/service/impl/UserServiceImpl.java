package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.repository.WxUserRepository;
import cn.yijianhao.wxtaroshopadmin0326.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final WxUserRepository wxUserRepository;

    public UserServiceImpl(WxUserRepository wxUserRepository) {
        this.wxUserRepository = wxUserRepository;
    }

    @Override
    public void updateWxUserProfileByOpenId(String openid, String avatar, String nickName) {
        int i = wxUserRepository.updateAvatarUrlAndNickNameByWxOpenid(openid, avatar, nickName);
        if (i == 0) {
            logger.debug("用户信息没有更新:{} -> {}, {}", openid, avatar, nickName);
        }
    }
}
