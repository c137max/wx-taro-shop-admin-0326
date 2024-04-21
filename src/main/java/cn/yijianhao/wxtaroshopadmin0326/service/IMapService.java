package cn.yijianhao.wxtaroshopadmin0326.service;

import cn.yijianhao.wxtaroshopadmin0326.DTO.SelfPickInfoDTO;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.SelfPickupVO;
import cn.yijianhao.wxtaroshopadmin0326.entity.SelfPickInfo;

import java.util.List;

public interface IMapService {
    // 获取自提点列表
    List<SelfPickInfoDTO> getSelfPickupList(SelfPickupVO vo);
}
