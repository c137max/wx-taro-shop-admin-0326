package cn.yijianhao.wxtaroshopadmin0326.system.auth;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;

public interface ITokenStorage {

    Token getToken(String tokenString);


    void addToken(Token token);

    void removeToken(Token token);
}
