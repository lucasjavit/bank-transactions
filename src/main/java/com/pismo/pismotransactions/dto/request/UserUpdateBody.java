package com.pismo.pismotransactions.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateBody {

    @NotNull(message = "Name is empty")
    private String name;
    private String email;
}
