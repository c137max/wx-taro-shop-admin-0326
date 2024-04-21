package cn.yijianhao.wxtaroshopadmin0326.controller.VO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.relational.core.sql.In;

@Data
@ToString
public class SelfPickupVO {
    // 传入经纬度
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    // 经纬度点方圆半径距离
    @NotNull
    @Max(1000)
    @Min(10)
    private Integer radius;
}
