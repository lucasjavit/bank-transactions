package com.pismo.pismotransactions.repository;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.util.AccountCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    @DisplayName("save_account_whenSuccessfull")
    public void save_account_whenSuccessfull() {
        Account accountToBeSaved = AccountCreator.createAccountToBeSaved();

        var accountSaved = accountRepository.save(accountToBeSaved);

        assertThat(accountSaved).isNotNull();
        assertThat(accountSaved.getId()).isNotNull();
    }

    @Test
    @DisplayName("findById_accountWhenSuccessful")
    public void findById_accountWhenSuccessful() {
        var accountSaved = accountRepository.save(AccountCreator.createAccountToBeSaved());

        Optional<Account> accountOptional = accountRepository.findById(1L);

        assertThat(accountOptional).isNotNull();

    }

}