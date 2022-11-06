package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.requests.AccountPostBody;
import com.pismo.pismotransactions.requests.AccountResponse;

public interface AccountService {

    AccountResponse save(AccountPostBody accountPostBody);

    AccountResponse findByDocumentNumber(Long accountId);
}
