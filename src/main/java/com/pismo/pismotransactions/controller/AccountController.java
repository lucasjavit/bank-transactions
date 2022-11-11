package com.pismo.pismotransactions.controller;

import com.pismo.pismotransactions.dto.request.AccountPostBody;
import com.pismo.pismotransactions.dto.response.AccountResponse;
import com.pismo.pismotransactions.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> save(@RequestBody @Valid AccountPostBody accountPostBody) {
        AccountResponse accountResponse = accountService.save(accountPostBody);
        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> findByDocumentNumber(@PathVariable long id) {
        return new ResponseEntity<>(accountService.findByDocumentNumber(id), HttpStatus.OK);
    }

}
