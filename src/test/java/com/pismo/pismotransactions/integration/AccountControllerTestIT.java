package com.pismo.pismotransactions.integration;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.requests.AccountPostBody;
import com.pismo.pismotransactions.requests.AccountResponse;
import com.pismo.pismotransactions.util.AccountCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTestIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;


    @Test
    @DisplayName("save_acccount_whenSuccessful")
    public void save_acccount_whenSuccessful() {
        AccountPostBody accountPostBody
                = AccountCreator.createAccountPostRequest();
        ResponseEntity<AccountResponse> accountResponseResponseEntity = testRestTemplate.postForEntity("/accounts",
                accountPostBody,
                AccountResponse.class
        );

        assertThat(accountResponseResponseEntity).isNotNull();
        assertThat(accountResponseResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(accountResponseResponseEntity.getBody()).isNotNull();
        assertThat(accountResponseResponseEntity.getBody().getDocumentNumber()).isNotNull();
    }

    @Test
    @DisplayName("findByDocumentNumber_acccount_whenSuccessful")
    public void findByDocumentNumber_acccount_whenSuccessful() {
        Account accountSaved = accountRepository.save(AccountCreator.createAccountToBeSaved());

        AccountResponse accountResponse = testRestTemplate.getForObject("/accounts/{id}", AccountResponse.class, 1231546l);

        assertThat(accountResponse).isNotNull();

        assertThat(accountResponse.getDocumentNumber()).isEqualTo(1231546l);

    }

}