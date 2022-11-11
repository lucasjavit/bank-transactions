package com.pismo.pismotransactions.util;

import com.pismo.pismotransactions.dto.request.TransactionPostBody;
import com.pismo.pismotransactions.dto.response.TransactionResponse;
import com.pismo.pismotransactions.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionCreator {

    public static Transaction createTransactionToBeSaved() {
        return Transaction.builder()
                .id(1L)
                .eventDate(LocalDateTime.now())
                .amount(BigDecimal.valueOf(123.45))
                .build();
    }

    public static Transaction createValidTransaction() {
        return Transaction.builder()
                .id(1L)
                .operationType(OperationTypeCreator.createOperationTypeToBeSaved())
                .account(AccountCreator.createValidAccount())
                .eventDate(LocalDateTime.now())
                .amount(BigDecimal.valueOf(123.45))
                .build();
    }

    public static TransactionPostBody createTransactionPostBodyToBeSaved() {
        return TransactionPostBody.builder()
                .accountId(1l)
                .amount(new BigDecimal(143.45))
                .operationTypeId(1l)
                .build();
    }

    public static TransactionResponse createTransationResponse() {
        return TransactionResponse.builder()
                .accountId(1l)
                .operationType(OperationTypeCreator.createOperationTypeToBeSaved())
                .amount(new BigDecimal(143.45))
                .eventDate(LocalDateTime.now().toString())
                .build();
    }
}
