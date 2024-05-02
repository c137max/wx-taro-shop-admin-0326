package cn.yijianhao.wxtaroshopadmin0326.service;

public interface IUserService {

    void updateWxUserProfileByOpenId(String openid, String avatar, String nickName);
}
