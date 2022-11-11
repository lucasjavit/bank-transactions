package com.pismo.pismotransactions.mapper;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.model.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    public abstract Account toEntity(AccountPostBody accountPostBody);

//    @Mapping(source = "account.transactions", target = "transactions")
    public abstract AccountResponse toDTO(Account account);

}
