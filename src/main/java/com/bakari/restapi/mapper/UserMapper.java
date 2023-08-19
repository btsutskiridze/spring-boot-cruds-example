package com.bakari.restapi.mapper;


import com.bakari.restapi.dto.UserPatchDto;
import com.bakari.restapi.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserPatchDto userPatchDto, @MappingTarget User user);
}
