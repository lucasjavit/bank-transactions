package com.pismo.pismotransactions.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class AccountResponse {

    private Long documentNumber;

    private List<TransactionResponse> transactions;

    private BigDecimal credit;
}
