package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.services.impl.AccountServiceIml;
import com.pismo.pismotransactions.util.AccountCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountServiceIml accountServiceIml;

    @Mock
    private AccountRepository accountRepository;


    @BeforeEach
    void setUp() {
        when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(AccountCreator.createValidAccount());
    }

    @Test
    void save() {
        AccountResponse accountSaved = accountServiceIml
                .save(AccountCreator.createAccountPostRequest());

        assertThat(accountSaved).isNotNull();
        assertThat(accountSaved.getCredit()).isNotNull().isEqualTo(new BigDecimal(100));
    }


    @Test
    void findByDocumentNumber() {
        when(accountRepository.findByDocumentNumber(ArgumentMatchers.any(Long.class))).thenReturn(Optional.ofNullable(AccountCreator.createValidAccount()));
        Long expecteddocument = AccountCreator.createValidAccount().getDocumentNumber();

        var account = accountServiceIml.findByDocumentNumber(123456l);

        assertThat(account).isNotNull();

        assertThat(account.getDocumentNumber()).isNotNull().isEqualTo(expecteddocument);
        assertThat(account.getCredit()).isNotNull().isEqualTo(new BigDecimal(100));

    }

    @Test
    void findBydocumentOrThrowAccountException() {
        when(accountRepository.findByDocumentNumber(ArgumentMatchers.any(Long.class))).thenReturn(Optional.ofNullable(AccountCreator.createValidAccount()));
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountServiceIml
                        .save(AccountCreator.createAccountPostRequest()));
    }

}