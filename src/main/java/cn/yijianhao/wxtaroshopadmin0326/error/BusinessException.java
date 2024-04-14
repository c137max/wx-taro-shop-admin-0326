package cn.yijianhao.wxtaroshopadmin0326.error;

import cn.yijianhao.wxtaroshopadmin0326.system.result.StatusEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BusinessException extends RuntimeException {
    private final StatusEnum statusEnum;
    private final String detailedMessage;

    public BusinessException(StatusEnum statusEnum, String detailedMessage) {
        this.statusEnum = statusEnum;
        this.detailedMessage = detailedMessage;
    }

}
