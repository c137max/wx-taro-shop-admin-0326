package cn.yijianhao.wxtaroshopadmin0326.system.auth;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.system.config.TokenConfig;
import cn.yijianhao.wxtaroshopadmin0326.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);
    private final ITokenStorage iTokenStorage;
    private final TokenConfig tokenConfig;

    public TokenService(ITokenStorage iTokenStorage, TokenConfig tokenConfig) {
        this.iTokenStorage = iTokenStorage;
        this.tokenConfig = tokenConfig;
    }

    public Token generateToken(String openid, String unionid, String sessionKey) {
        Token token = Token.builder()
                .openid(openid)
                .unionid(unionid)
                .sessionKey(sessionKey)
                .build();
        token.setExpiresIn(DateUtil.plusSeconds(
                new Date(),
                tokenConfig.getExpSecond()));
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
