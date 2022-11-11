package com.pismo.pismotransactions.mapper;

import com.pismo.pismotransactions.dto.request.UserPostBody;
import com.pismo.pismotransactions.dto.response.UserResponse;
import com.pismo.pismotransactions.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toEntity(UserPostBody userPostBody);

    @Mapping(source = "user.accounts", target = "accounts")
    public abstract UserResponse toDTO(User user);

}
