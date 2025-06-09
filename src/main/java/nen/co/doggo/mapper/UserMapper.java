package nen.co.doggo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.entity.UserEntity;

@Mapper
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

}
