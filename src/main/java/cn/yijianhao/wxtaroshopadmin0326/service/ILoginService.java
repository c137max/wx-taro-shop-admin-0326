package cn.yijianhao.wxtaroshopadmin0326.service;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;

public interface ILoginService {
    Token wxLogin(String code);
}
