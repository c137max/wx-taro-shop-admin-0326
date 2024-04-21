package cn.yijianhao.wxtaroshopadmin0326.service.impl;

import cn.yijianhao.wxtaroshopadmin0326.DTO.SelfPickInfoDTO;
import cn.yijianhao.wxtaroshopadmin0326.beanMapper.BeanMapper;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.SelfPickupVO;
import cn.yijianhao.wxtaroshopadmin0326.entity.SelfPickInfo;
import cn.yijianhao.wxtaroshopadmin0326.repository.SelfPickInfoRepository;
import cn.yijianhao.wxtaroshopadmin0326.service.IMapService;
import cn.yijianhao.wxtaroshopadmin0326.utils.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MapServiceImpl implements IMapService {

    //    private final Logger logger = LoggerFactory.getLogger(IMapService.class);
    private final SelfPickInfoRepository selfPickInfoRepository;

    public MapServiceImpl(SelfPickInfoRepository selfPickInfoRepository) {
        this.selfPickInfoRepository = selfPickInfoRepository;
    }

    @Override
    public List<SelfPickInfoDTO> getSelfPickupList(SelfPickupVO vo) {
        List<SelfPickInfo> allPickInfo = selfPickInfoRepository.findAll();
        List<SelfPickInfoDTO> selfPickInfoDTOS = BeanMapper.INSTANCE.toSelfPickInfoDTOList(allPickInfo);
        // 计算出两点之间的距离
        return selfPickInfoDTOS.stream()
                .peek(selfPickInfoDTO -> {
                    int distance = MapUtil.getDistance(vo.getLatitude(), vo.getLongitude(), selfPickInfoDTO.getLatitude(), selfPickInfoDTO.getLongitude());
                    selfPickInfoDTO.setDistance(distance);
                })
                .filter(selfPickInfoDTO -> selfPickInfoDTO.getDistance() <= vo.getRadius())
                .sorted(Comparator.comparingInt(SelfPickInfoDTO::getDistance))
                .toList();


    }
}
