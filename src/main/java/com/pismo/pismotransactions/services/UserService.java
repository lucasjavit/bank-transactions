package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.dto.request.UserPostBody;
import com.pismo.pismotransactions.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse save(UserPostBody userPostBody);


    UserResponse findById(long id);
}
