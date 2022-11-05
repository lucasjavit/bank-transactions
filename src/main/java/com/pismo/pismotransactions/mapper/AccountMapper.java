package com.pismo.pismotransactions.mapper;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.requests.AccountPostBody;
import com.pismo.pismotransactions.requests.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    public abstract Account toEntity(AccountPostBody accountPostBody);

    public static AccountResponse toDTO(Account account) {
        return AccountResponse.builder()
                .documentNumber(account.getDocumentNumber())
                .transactions(account.getTransactions() == null ? new ArrayList<>() : TransactionMapper.INSTANCE.toListDTO(account.getTransactions()))
                .build();
    }
}
