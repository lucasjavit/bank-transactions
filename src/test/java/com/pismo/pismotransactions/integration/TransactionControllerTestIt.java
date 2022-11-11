package com.pismo.pismotransactions.integration;

import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.repository.TransactionRepository;
import com.pismo.pismotransactions.dto.request.TransactionPostBody;
import com.pismo.pismotransactions.dto.response.TransactionResponse;
import com.pismo.pismotransactions.util.AccountCreator;
import com.pismo.pismotransactions.util.TransactionCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTestIt {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    @BeforeEach
    void setUp() {
        accountRepository.save(AccountCreator.createAccountToBeSaved());
    }

    @Test
    @DisplayName("save_transaction_whenSuccessful")
    public void save_transaction_whenSuccessful() {
        TransactionPostBody transactionSaved = TransactionCreator.createTransactionPostBodyToBeSaved();

        ResponseEntity<TransactionResponse> transactionResponseResponseEntity = testRestTemplate.postForEntity("/transactions", transactionSaved, TransactionResponse.class);


        assertThat(transactionResponseResponseEntity).isNotNull();
        assertThat(transactionResponseResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(transactionResponseResponseEntity.getBody()).isNotNull();
    }
}
