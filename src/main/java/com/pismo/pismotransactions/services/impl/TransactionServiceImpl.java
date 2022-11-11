package com.pismo.pismotransactions.services.impl;

import com.pismo.pismotransactions.dto.request.TransactionPostBody;
import com.pismo.pismotransactions.dto.response.TransactionResponse;
import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.exception.TransactionException;
import com.pismo.pismotransactions.mapper.TransactionMapper;
import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.patterns.OperationTypeStrategy;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.repository.OperationTypetRepository;
import com.pismo.pismotransactions.repository.TransactionRepository;
import com.pismo.pismotransactions.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final OperationTypetRepository operationTypeRepository;


    @Transactional
    public TransactionResponse save(TransactionPostBody transactionPostBody) {

        var account = accountRepository.findById(transactionPostBody.getAccountId())
                .orElseThrow(() -> new TransactionException("Account not founded."));

        if (transactionPostBody.getAmount().compareTo(account.getCredit()) < 1) {
            throw new AccountException("Operation invalid: amount is bigger than credit.");
        }

        var operationType = operationTypeRepository.findById(transactionPostBody.getOperationTypeId())
                .orElseThrow(() -> new TransactionException("Operation Type is is incorrect."));

        OperationTypeStrategy operationTypeStrategy = OperationType.getOperationType(operationType.getId());

        var amount = operationTypeStrategy.setSign(transactionPostBody.getAmount());

        BigDecimal newCredit = operationTypeStrategy.calculateCredit(account.getCredit(), amount);

        isOperationValid(newCredit);

        account.setCredit(newCredit);

        var transaction = TransactionMapper.toEntity(account, operationType, amount);
        transaction.setAccount(account);

        account.getTransactions().add(transaction);

        return TransactionMapper.INSTANCE.toDTO(transactionRepository.save(transaction));
    }

    private void isOperationValid(BigDecimal newCredit) {
        if (newCredit.compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountException("Operation invalid: credit is less than Zero");
        }
    }


}
