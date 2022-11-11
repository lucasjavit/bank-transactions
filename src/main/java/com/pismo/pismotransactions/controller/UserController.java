package com.pismo.pismotransactions.controller;

import com.pismo.pismotransactions.dto.request.UserPostBody;
import com.pismo.pismotransactions.dto.response.UserResponse;
import com.pismo.pismotransactions.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserPostBody userPostBody) {
        return new ResponseEntity<>(userService.save(userPostBody), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findByDocumentNumber(@PathVariable long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

}
