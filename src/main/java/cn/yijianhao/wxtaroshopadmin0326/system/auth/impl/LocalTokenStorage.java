package cn.yijianhao.wxtaroshopadmin0326.system.auth.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.system.auth.ITokenStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class LocalTokenStorage implements ITokenStorage {

    private static final List<Token> tokens = new ArrayList<>();


    @Override
    public Token getToken(String tokenString) {
        Optional<Token> first = tokens.stream().filter(t -> t.getAccessToken().equals(tokenString)).findFirst();
        if (first.isEmpty()) {
            return null;
        }
        Token token = first.get();
        // 检查是否已经过期
        if (token.getExpiresIn().compareTo(new Date()) > 0) {
            tokens.remove(token);
            return null;
        }
        return token;
    }


    @Override
    public void addToken(Token token) {
        tokens.add(token);
    }

    @Override
    public void removeToken(Token token) {
        tokens.remove(token);
    }
}
