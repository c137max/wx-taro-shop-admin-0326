package cn.yijianhao.wxtaroshopadmin0326.service;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Code2SessionRespDTO;

public interface IHttpService {

    Code2SessionRespDTO code2Session(String appid, String secret, String jsCode, String grantType);
}
