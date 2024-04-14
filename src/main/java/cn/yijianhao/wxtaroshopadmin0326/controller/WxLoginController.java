package cn.yijianhao.wxtaroshopadmin0326.controller;

import cn.yijianhao.wxtaroshopadmin0326.controller.VO.Code2SessionRepVO;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.Code2SessionVO;
import cn.yijianhao.wxtaroshopadmin0326.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.result.Results;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/wxLogin")
public class WxLoginController {

    @PostMapping("/code2Session")
    public Response<Code2SessionRepVO> code2Session(@RequestBody @Validated Code2SessionVO vo) {

        var repVO = new Code2SessionRepVO("unionid", "openid", "123456");
        return Results.ok(repVO);
    }
}
