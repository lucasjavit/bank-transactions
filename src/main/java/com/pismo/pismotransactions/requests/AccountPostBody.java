package com.pismo.pismotransactions.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPostBody {

    @JsonProperty("document_number")
    @NotNull(message = "The documentNumber cannot be empty")
    private Long documentNumber;
}
