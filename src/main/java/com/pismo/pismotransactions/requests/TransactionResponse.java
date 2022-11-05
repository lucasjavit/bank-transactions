package com.pismo.pismotransactions.requests;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionResponse {

    private Long transactionId;

    private Long accountId;

    private Long operationTypeId;

    private BigDecimal amount;

    private String eventDate;
}
