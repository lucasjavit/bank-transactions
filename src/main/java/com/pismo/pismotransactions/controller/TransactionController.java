package com.pismo.pismotransactions.controller;

import com.pismo.pismotransactions.dto.request.TransactionPostBody;
import com.pismo.pismotransactions.dto.response.TransactionResponse;
import com.pismo.pismotransactions.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> save(@RequestBody @Valid TransactionPostBody transactionPostBody) {
        TransactionResponse transactionResponse = transactionService.save(transactionPostBody);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

}
