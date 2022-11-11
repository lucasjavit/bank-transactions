package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;

public interface AccountService {

    AccountResponse save(AccountPostBody accountPostBody);

    AccountResponse findByDocumentNumber(Long accountId);
}
