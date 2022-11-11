package com.pismo.pismotransactions.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class TransactionPostBody {

    @JsonProperty("account_id")
    @NotNull(message = "The transactionID cannot be null")
    private Long accountId;

    @JsonProperty("operation_type_id")
    @NotNull(message = "The operationTypeId cannot be null")
    private Long operationTypeId;

    @NotNull(message = "The amount cannot be null")
    @DecimalMin(value = "1.0", message = "amount should be equal or bigger than 1.0")
    private BigDecimal amount;

}
