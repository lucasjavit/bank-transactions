package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.dto.request.TransactionPostBody;
import com.pismo.pismotransactions.dto.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse save(TransactionPostBody transactionPostBody);

}
