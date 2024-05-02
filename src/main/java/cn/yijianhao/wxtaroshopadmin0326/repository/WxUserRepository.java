package cn.yijianhao.wxtaroshopadmin0326.repository;

import cn.yijianhao.wxtaroshopadmin0326.entity.WxUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface WxUserRepository extends Repository<WxUser, Long> {

    boolean existsByWxOpenid(String wxOpenid);
    WxUser findByWxOpenid(String wxOpenid);

    WxUser save(WxUser wxUser);
    @Modifying
    @Transactional
    @Query("UPDATE WxUser w SET w.avatarUrl = :avatarUrl, w.nickName = :nickName WHERE w.wxOpenid = :wxOpenid")
    int updateAvatarUrlAndNickNameByWxOpenid(String wxOpenid, String avatarUrl, String nickName);
}
