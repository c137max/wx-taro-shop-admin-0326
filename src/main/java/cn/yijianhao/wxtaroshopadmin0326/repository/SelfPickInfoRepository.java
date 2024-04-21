package cn.yijianhao.wxtaroshopadmin0326.repository;

import cn.yijianhao.wxtaroshopadmin0326.entity.SelfPickInfo;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SelfPickInfoRepository extends Repository<SelfPickInfo, Long> {
    List<SelfPickInfo> findAll();
    SelfPickInfo save(SelfPickInfo selfPickInfo);
}
