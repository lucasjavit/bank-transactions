package com.pismo.pismotransactions.repository;

import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.model.Transaction;
import com.pismo.pismotransactions.util.AccountCreator;
import com.pismo.pismotransactions.util.OperationTypeCreator;
import com.pismo.pismotransactions.util.TransactionCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class TransactionRepositoryTest {


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationTypetRepository operationTypetRepository;


    @Test
    @DisplayName("should Be Save transaction When Successful")
    public void shouldBeSavetransactionWhenSuccessful() {

        accountRepository.save(AccountCreator.createValidAccount());
        operationTypetRepository.save(OperationTypeCreator.createOperationTypeToBeSaved());

        Transaction transactionToBeSaved = TransactionCreator.createTransactionToBeSaved();

        Account account = accountRepository.findById(1L).get();

        transactionToBeSaved.setAccount(account);
        transactionToBeSaved.setOperationType(operationTypetRepository.getReferenceById(1l));

        Transaction transaction = transactionRepository.save(transactionToBeSaved);

        assertThat(transaction).isNotNull();
        assertThat(transaction.getId()).isNotNull();
        assertThat(transaction.getAccount()).isNotNull();
        assertThat(transaction.getAmount()).isNotZero();
        assertThat(transaction.getOperationType()).isNotNull();
    }


}