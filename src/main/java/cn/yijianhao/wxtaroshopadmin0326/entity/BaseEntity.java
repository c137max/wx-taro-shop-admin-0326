package cn.yijianhao.wxtaroshopadmin0326.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
    private boolean isDeleted;

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
