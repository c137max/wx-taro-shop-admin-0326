package cn.yijianhao.wxtaroshopadmin0326.controller;


import cn.yijianhao.wxtaroshopadmin0326.controller.VO.WxUserProfileVO;
import cn.yijianhao.wxtaroshopadmin0326.service.IUserService;
import cn.yijianhao.wxtaroshopadmin0326.system.UserContext;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Results;
import cn.yijianhao.wxtaroshopadmin0326.system.result.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PutMapping("/wxUser/{openId}")
    public Response<String> updateWxUserProfile(@PathVariable String openId, @RequestBody @Validated WxUserProfileVO wxUserProfileVO) {
        logger.debug(wxUserProfileVO.toString());
        if (!Objects.equals(UserContext.getOpenId(), openId)) {
            return Results.fail(StatusEnum.PARAM_ERROR);
        }
        iUserService.updateWxUserProfileByOpenId(openId, wxUserProfileVO.avatarUrl(), wxUserProfileVO.nickName());
        return Results.ok();
    }
}
