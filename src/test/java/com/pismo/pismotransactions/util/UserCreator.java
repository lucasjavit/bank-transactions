package com.pismo.pismotransactions.util;

import com.pismo.pismotransactions.model.User;

import java.util.Arrays;

public class UserCreator {

    public static User getUserSaved() {
        return User.builder()
                .id(1l)
                .name("ze")
                .email("ze@gmail.com")
                .accounts(Arrays.asList(AccountCreator.createValidAccount()))
                .build();
    }
}
