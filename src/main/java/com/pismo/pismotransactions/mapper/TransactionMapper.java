package com.pismo.pismotransactions.mapper;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.model.Transaction;
import com.pismo.pismotransactions.dto.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {

    public static final TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    public static TransactionResponse toDTO(Transaction transaction) {
        return TransactionResponse.builder()
                .transactionId(transaction.getId())
                .accountId(transaction.getAccount().getId())
                .operationTypeId(transaction.getOperationType().getId())
                .amount(transaction.getAmount())
                .eventDate(transaction.getEventDate().toString())
                .build();
    }

    public static Transaction toEntity(Account account, OperationType operationType, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        transaction.setAmount(amount);
        transaction.setEventDate(LocalDateTime.now());
        return transaction;
    }

    public List<TransactionResponse> toListDTO(List<Transaction> transactions) {
        return transactions.stream().map(it -> toDTO(it)).collect(Collectors.toList());
    }
}
