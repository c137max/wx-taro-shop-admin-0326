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
public class WxUser extends BaseEntity {
    private String wxOpenid;
    private String wxUnionid;
    private String nickName;
    private String avatarUrl;
}
