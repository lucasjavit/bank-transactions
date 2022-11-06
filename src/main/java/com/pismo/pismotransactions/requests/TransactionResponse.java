package com.pismo.pismotransactions.requests;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TransactionResponse {

    private Long transactionId;

    private Long accountId;

    private Long operationTypeId;

    private BigDecimal amount;

    private String eventDate;
}
