package com.pismo.pismotransactions.dto.response;

import com.pismo.pismotransactions.model.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long accountId;

    private OperationType operationType;

    private BigDecimal amount;

    private String eventDate;
}
