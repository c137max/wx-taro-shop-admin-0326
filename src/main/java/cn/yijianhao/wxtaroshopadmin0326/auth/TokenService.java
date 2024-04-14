package cn.yijianhao.wxtaroshopadmin0326.auth;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);
    private final ITokenStorage iTokenStorage;

    public TokenService(ITokenStorage iTokenStorage) {
        this.iTokenStorage = iTokenStorage;
    }

    public Token generateToken(String openid, String unionid, String sessionKey) {
        Token token = Token.builder()
                .openid(openid)
                .unionid(unionid)
                .sessionKey(sessionKey)
                .build();
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        token.setAccessToken(uuidString.replace("-", ""));
        logger.debug("token generated {}", token);
        iTokenStorage.addToken(token);
        return token;
    }

    public Token getToken(String tokenString) {
        Token token = iTokenStorage.getToken(tokenString);
        logger.debug("token retrieved {}", token);
        return token;
    }
}
