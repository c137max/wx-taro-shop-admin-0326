package cn.yijianhao.wxtaroshopadmin0326.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MapUtil {

    private final static double EARTH_RADIUS = 6378.137; // 地球半径

//    private static double rad(double d) {
//        return d * Math.PI / 180.0;
//    }

    /**
     * 计算国内坐标系两点间距离
     *
     * @return int 距离，单位米
     */
    public static int getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);
        double a = radLat1 - radLat2;
        double b = Math.toRadians(lng1) - Math.toRadians(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS * 1000; // 转换为米
        return (int) Math.round(s); // 返回整数距离
    }
}
