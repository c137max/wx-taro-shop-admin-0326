package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.UserProfileDTO;
import cn.yijianhao.wxtaroshopadmin0326.beanMapper.BeanMapper;
import cn.yijianhao.wxtaroshopadmin0326.entity.WxUser;
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

    @Override
    public UserProfileDTO getWxUserProfileByOpenId(String openid) {
        WxUser wxUser = wxUserRepository.findByWxOpenid(openid);
        return BeanMapper.INSTANCE.toUserProfileDTO(wxUser);
    }
}
