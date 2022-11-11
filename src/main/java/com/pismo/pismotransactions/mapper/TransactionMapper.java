package com.pismo.pismotransactions.mapper;

import com.pismo.pismotransactions.dto.response.TransactionResponse;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.model.Transaction;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class TransactionMapper {

    public static final TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    @Mapping(source = "transaction.account.id", target = "accountId")
    @Mapping(source = "transaction.operationType.", target = "operationType")
    public abstract TransactionResponse toDTO(Transaction transaction);


    public static Transaction toEntity(Account account, OperationType operationType, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        transaction.setAmount(amount);
        transaction.setEventDate(LocalDateTime.now());
        return transaction;
    }

}
