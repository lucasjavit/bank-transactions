package com.pismo.pismotransactions.util;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.requests.AccountPostBody;
import com.pismo.pismotransactions.requests.AccountResponse;

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
