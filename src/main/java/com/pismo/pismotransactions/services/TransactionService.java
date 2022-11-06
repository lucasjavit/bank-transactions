package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.requests.TransactionPostBody;
import com.pismo.pismotransactions.requests.TransactionResponse;

public interface TransactionService {

    TransactionResponse save(TransactionPostBody transactionPostBody);

}
