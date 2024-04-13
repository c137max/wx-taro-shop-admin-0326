package cn.yijianhao.wxtaroshopadmin0326.result;

public class Results {

    public static <T> Response<T> resp(String msg, int code, T data) {
        return new Response<T>(code, msg, data);
    }

    public static <T> Response<T> resp(StatusEnum status, T data) {
        return new Response<T>(status.getCode(), status.getMsg(), data);
    }

    public static <T> Response<T> ok(T result) {
        return resp(StatusEnum.SUCCESS, result);
    }

    public static Response<String> ok() {
        return resp(StatusEnum.SUCCESS, "");
    }

    public static Response<String> fail(StatusEnum status) {
        return new Response<>(status.getCode(), status.getMsg(), "");
    }

    public static Response<String> fail() {
        var status = StatusEnum.FAIL;
        return fail(status);
    }

}
