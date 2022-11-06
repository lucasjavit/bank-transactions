package com.pismo.pismotransactions.services.impl;

import com.pismo.pismotransactions.exception.TransactionException;
import com.pismo.pismotransactions.mapper.TransactionMapper;
import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.repository.OperationTypetRepository;
import com.pismo.pismotransactions.repository.TransactionRepository;
import com.pismo.pismotransactions.requests.TransactionPostBody;
import com.pismo.pismotransactions.requests.TransactionResponse;
import com.pismo.pismotransactions.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

        var operationType = operationTypeRepository.findById(transactionPostBody.getOperationTypeId())
                .orElseThrow(() -> new TransactionException("Operation Type is is incorrect."));


        var amount = getAmount(transactionPostBody.getAmount(), operationType);

        var transaction = TransactionMapper.toEntity(account, operationType, amount);

        return TransactionMapper.INSTANCE.toDTO(transactionRepository.save(transaction));
    }

    public BigDecimal getAmount(BigDecimal amount, OperationType operationType) {
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        return longs.contains(operationType.getId()) ? amount.negate() : amount;
    }

}
