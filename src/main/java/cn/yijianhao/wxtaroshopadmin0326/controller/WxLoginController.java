package cn.yijianhao.wxtaroshopadmin0326.controller;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Token;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.Code2SessionRepVO;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.Code2SessionVO;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Results;
import cn.yijianhao.wxtaroshopadmin0326.service.ILoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/wxLogin")
public class WxLoginController {

    private final ILoginService loginService;

    public WxLoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/code2Session")
    public Response<Code2SessionRepVO> code2Session(@RequestBody @Validated Code2SessionVO vo) {
        Token token = loginService.wxLogin(vo.getCode());
        var repVO = new Code2SessionRepVO(token.getUnionid(), token.getOpenid(), token.getAccessToken());
        return Results.ok(repVO);
    }
}
