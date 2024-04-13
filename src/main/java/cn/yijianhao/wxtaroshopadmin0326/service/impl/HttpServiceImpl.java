package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.Code2SessionRespDTO;
import cn.yijianhao.wxtaroshopadmin0326.service.IHttpService;
import cn.yijianhao.wxtaroshopadmin0326.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class HttpServiceImpl implements IHttpService {

    Logger logger =  LoggerFactory.getLogger(HttpServiceImpl.class);

    private static final int MAX_RETRIES = 5;  // 最大重试次数

    private Response syncRequest(Request req, int failures) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(req).execute();
            if (!response.isSuccessful()) {
                if (failures < MAX_RETRIES) {
                    return syncRequest(req, failures + 1);
                } else {
                    throw new Exception("Http request failed: " + response.message());
                }
            }
            return response;
        } catch (Exception e) {
            logger.error("Http request failed: " + e);
        } finally {
            okHttpClient.clone();
        }
        return null;
    }

    private Response syncRequest(Request req) {
        return syncRequest(req, 0);
    }


    public Code2SessionRespDTO code2Session(String appid, String secret, String jsCode, String grantType) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=" + grantType;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = syncRequest(request);
        logger.info(response.message());
        ResponseBody body = response.body();
        if (body == null) {
            logger.error("发起code2Session失败");
            return null;
        }
        try {
            return JsonUtil.parseToObject(body.string(), Code2SessionRespDTO.class);
        } catch (IOException e) {
            logger.error("解析code2Session响应数据失败：" + e.getMessage());
            return null;
        }
    }
}
