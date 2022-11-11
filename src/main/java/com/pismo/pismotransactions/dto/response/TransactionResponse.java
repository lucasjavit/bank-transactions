package com.pismo.pismotransactions.dto.response;

import com.pismo.pismotransactions.model.OperationType;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TransactionResponse {

    private Long accountId;

    private OperationType operationType;

    private BigDecimal amount;

    private String eventDate;
}
