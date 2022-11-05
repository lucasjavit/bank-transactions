package com.pismo.pismotransactions.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountResponse {

    private Long documentNumber;

    private List<TransactionResponse> transactions;
}
