package com.pismo.pismotransactions.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private List<AccountResponse> accounts;
}
