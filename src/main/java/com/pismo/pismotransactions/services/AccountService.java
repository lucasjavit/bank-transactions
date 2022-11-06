package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.mapper.AccountMapper;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.requests.AccountPostBody;
import com.pismo.pismotransactions.requests.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponse save(AccountPostBody accountPostBody) {
        isAccountExists(accountPostBody.getDocumentNumber());

        Account account = AccountMapper.INSTANCE.toEntity(accountPostBody);

        return AccountMapper.toDTO(accountRepository.save(account));
    }

    public AccountResponse findByDocumentNumber(Long accountId) {
        return AccountMapper.toDTO(accountRepository.findByDocumentNumber(accountId).get());
    }

    private void isAccountExists(Long documentNumber) {
        if (accountRepository.findByDocumentNumber(documentNumber).isPresent()) {
            throw new AccountException("Account already exists with documentNumer: " + documentNumber);
        }
    }

}
