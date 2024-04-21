package cn.yijianhao.wxtaroshopadmin0326.beanMapper;

import cn.yijianhao.wxtaroshopadmin0326.DTO.SelfPickInfoDTO;
import cn.yijianhao.wxtaroshopadmin0326.entity.SelfPickInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeanMapper {
    BeanMapper INSTANCE = Mappers.getMapper(BeanMapper.class);
    @Mapping(target = "distance", constant = "-1")
    SelfPickInfoDTO toSelfPickInfoDTO(SelfPickInfo selfPickInfo);
    List<SelfPickInfoDTO> toSelfPickInfoDTOList(List<SelfPickInfo> selfPickInfos);
}
