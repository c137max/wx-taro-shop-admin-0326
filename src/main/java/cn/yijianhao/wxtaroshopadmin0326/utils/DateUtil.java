package cn.yijianhao.wxtaroshopadmin0326.utils;

import java.util.Date;

public class DateUtil {

    public static Date plusSeconds(Date date, long seconds) {
        return new Date(date.getTime() + seconds * 1000);
    }
}
