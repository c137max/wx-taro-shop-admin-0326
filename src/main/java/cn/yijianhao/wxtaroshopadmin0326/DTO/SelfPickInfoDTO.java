package cn.yijianhao.wxtaroshopadmin0326.DTO;

import lombok.*;
import org.springframework.data.relational.core.sql.In;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelfPickInfoDTO {
    private Long id;
    private String displayName;
    private String avatarUrl;
    // 联系人电话
    private String phone;
    // 联系人姓名
    private String contactName;
    private String address;
    // gcj02 坐标系
    private Double longitude;  // 经度
    private Double latitude;  // 纬度
    private Integer distance;
}
