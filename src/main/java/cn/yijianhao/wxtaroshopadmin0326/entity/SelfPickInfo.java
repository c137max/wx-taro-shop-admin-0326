package cn.yijianhao.wxtaroshopadmin0326.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelfPickInfo extends BaseEntity {
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
}
