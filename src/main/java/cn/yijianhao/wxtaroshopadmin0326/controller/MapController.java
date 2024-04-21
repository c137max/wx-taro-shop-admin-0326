package cn.yijianhao.wxtaroshopadmin0326.controller;

import cn.yijianhao.wxtaroshopadmin0326.DTO.SelfPickInfoDTO;
import cn.yijianhao.wxtaroshopadmin0326.controller.VO.SelfPickupVO;
import cn.yijianhao.wxtaroshopadmin0326.entity.SelfPickInfo;
import cn.yijianhao.wxtaroshopadmin0326.service.IMapService;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Response;
import cn.yijianhao.wxtaroshopadmin0326.system.result.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MapController {
    private final Logger logger =  LoggerFactory.getLogger(MapController.class);
    private final IMapService mapService;

    public MapController(IMapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("/selfPickup")
    public Response<List<SelfPickInfoDTO>> selfPickup(@RequestBody SelfPickupVO vo) {
        logger.debug(vo.toString());
        List<SelfPickInfoDTO> selfPickupList = mapService.getSelfPickupList(vo);
        logger.debug("查询到的自提点数量：{}", selfPickupList.size());
        return Results.ok(selfPickupList);
    }
}
