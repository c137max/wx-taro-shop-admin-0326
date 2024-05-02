package cn.yijianhao.wxtaroshopadmin0326.system;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.enums.UserType;

public class UserContext {

    private static final ThreadLocal<Token> userToken = new ThreadLocal<>();

    public static void setUserInfo(Token token) {
        userToken.set(token);
    }

    public static Token getUserToken() {
        return userToken.get();
    }

    public static Long getUserId() {
        return getUserToken().getUserId();
    }

    public static String getOpenId() {
        return getUserToken().getOpenid();
    }

    public static UserType getUserType() {
        return getUserToken().getUserType();
    }
}

