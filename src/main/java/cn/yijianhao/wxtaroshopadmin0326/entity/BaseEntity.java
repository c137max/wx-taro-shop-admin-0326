package cn.yijianhao.wxtaroshopadmin0326.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
    private boolean isDeleted;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PrePersist
    protected void onCreate() {
        createTime = new Date();
        updateTime = new Date();
        isDeleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = new Date();
    }
}
