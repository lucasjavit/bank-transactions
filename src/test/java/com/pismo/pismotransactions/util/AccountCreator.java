package com.pismo.pismotransactions.util;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountCreator {

    public static Account createAccountToBeSaved() {
        return Account.builder()
                .documentNumber(1231546l)
                .transactions(new ArrayList<>())
                .build();
    }

    public static Account createValidAccount() {
        return Account.builder()
                .id(1l)
                .credit(new BigDecimal(100))
                .documentNumber(1231546l)
                .transactions(new ArrayList<>())
                .build();
    }

    public static AccountPostBody createAccountPostRequest() {

        return AccountPostBody.builder()
                .documentNumber(12345l)
                .build();
    }

    public static AccountResponse createAccountResponse() {
        return AccountResponse.builder()
                .documentNumber(123456l)
                .transactions(new ArrayList<>())
                .build();
    }
}
