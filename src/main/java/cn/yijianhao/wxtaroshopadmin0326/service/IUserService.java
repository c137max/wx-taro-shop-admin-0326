package cn.yijianhao.wxtaroshopadmin0326.service;

import cn.yijianhao.wxtaroshopadmin0326.DTO.UserProfileDTO;

public interface IUserService {

    void updateWxUserProfileByOpenId(String openid, String avatar, String nickName);
    UserProfileDTO getWxUserProfileByOpenId(String openid);
}
