package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.exception.TransactionException;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.model.Transaction;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.repository.OperationTypetRepository;
import com.pismo.pismotransactions.repository.TransactionRepository;
import com.pismo.pismotransactions.requests.TransactionResponse;
import com.pismo.pismotransactions.util.AccountCreator;
import com.pismo.pismotransactions.util.OperationTypeCreator;
import com.pismo.pismotransactions.util.TransactionCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TransactionServiceTest {


    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private OperationTypetRepository operationTypetRepository;

    @Mock
    private TransactionRepository transactionRepository;


    @Test
    void save() {

        mockTransactionSaveRepository();

        TransactionResponse transactionResponse = transactionService
                .save(TransactionCreator.createTransactionPostBodyToBeSaved());

        assertThat(transactionResponse).isNotNull();
    }

    @Test
    void findAccountWithNotExistingIdShouldThrowTransactionException() {
        mockTransactionSaveRepositoryWithoutAccount();

        assertThatExceptionOfType(TransactionException.class)
                .isThrownBy(() -> transactionService
                        .save(TransactionCreator.createTransactionPostBodyToBeSaved()));
    }

    private void mockTransactionSaveRepositoryWithoutAccount() {
        when(operationTypetRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.ofNullable(OperationTypeCreator.createOperationTypeToBeSaved()));
    }


    private void mockTransactionSaveRepository() {
        when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(AccountCreator.createValidAccount());
        when(operationTypetRepository.save(OperationTypeCreator.createOperationTypeToBeSaved())).thenReturn(OperationTypeCreator.createOperationTypeToBeSaved());
        when(transactionRepository.save(ArgumentMatchers.any(Transaction.class))).thenReturn(TransactionCreator.createValidTransaction());

        when(operationTypetRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.ofNullable(OperationTypeCreator.createOperationTypeToBeSaved()));
        when(accountRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.ofNullable(AccountCreator.createValidAccount()));
    }


}