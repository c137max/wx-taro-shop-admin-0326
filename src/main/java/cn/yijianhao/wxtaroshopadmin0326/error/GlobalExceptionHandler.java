package cn.yijianhao.wxtaroshopadmin0326.error;

import cn.yijianhao.wxtaroshopadmin0326.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.result.Results;
import cn.yijianhao.wxtaroshopadmin0326.result.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response<String> handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return Results.fail(StatusEnum.SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Response<String> handleException(BusinessException ex) {
        logger.error("业务异常： " + ex.getDetailedMessage());
        return Results.fail(ex.getStatusEnum());
    }
}
