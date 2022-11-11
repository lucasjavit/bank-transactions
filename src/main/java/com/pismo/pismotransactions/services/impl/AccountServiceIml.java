package com.pismo.pismotransactions.services.impl;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.mapper.AccountMapper;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceIml implements AccountService {

    private final AccountRepository accountRepository;

    public AccountResponse save(AccountPostBody accountPostBody) {
        isAccountExists(accountPostBody.getDocumentNumber());

        Account account = AccountMapper.INSTANCE.toEntity(accountPostBody);
        account.setCredit(new BigDecimal(100).setScale(2));

        return AccountMapper.INSTANCE.toDTO(accountRepository.save(account));
    }

    public AccountResponse findByDocumentNumber(Long accountId) {
        Optional<Account> account = Optional.ofNullable(accountRepository.findByDocumentNumber(accountId)
                .orElseThrow(() -> new AccountException("Account not founded")));

        return AccountMapper.INSTANCE.toDTO(account.get());
    }

    private void isAccountExists(Long documentNumber) {
        if (accountRepository.findByDocumentNumber(documentNumber).isPresent()) {
            throw new AccountException("Account already exists with documentNumer: " + documentNumber);
        }
    }

}
