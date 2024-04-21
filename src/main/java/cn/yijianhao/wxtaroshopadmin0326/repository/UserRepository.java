package cn.yijianhao.wxtaroshopadmin0326.repository;

import cn.yijianhao.wxtaroshopadmin0326.entity.WxUser;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<WxUser, Long> {

    boolean existsByWxOpenid(String wxOpenid);

    WxUser save(WxUser wxUser);
}
