package cn.yijianhao.wxtaroshopadmin0326.controller.VO;

import jakarta.validation.constraints.NotBlank;

public record WxUserProfileVO(
        @NotBlank String nickName,
        @NotBlank String avatarUrl
) {
}
