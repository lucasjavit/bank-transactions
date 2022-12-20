package com.pismo.pismotransactions.services.impl;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.exception.AccountException;
import com.pismo.pismotransactions.mapper.AccountMapper;
import com.pismo.pismotransactions.model.Account;
import com.pismo.pismotransactions.repository.AccountRepository;
import com.pismo.pismotransactions.repository.UserRepository;
import com.pismo.pismotransactions.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceIml implements AccountService {
    @Enumerated(EnumType.STRING)
    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    public AccountResponse save(AccountPostBody accountPostBody) {
        isAccountExists(accountPostBody.getDocumentNumber());

        var user = userRepository.findById(accountPostBody.getUserId())
                .orElseThrow(() -> new AccountException("User not founded"));

        Account account = AccountMapper.INSTANCE.toEntity(accountPostBody);
        account.setCredit(new BigDecimal(100).setScale(2));
        account.setUser(user);

        user.getAccounts().add(account);

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
