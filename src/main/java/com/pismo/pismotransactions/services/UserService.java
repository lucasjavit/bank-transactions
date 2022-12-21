package com.pismo.pismotransactions.services;

import com.pismo.pismotransactions.dto.request.UserPostBody;
import com.pismo.pismotransactions.dto.request.UserUpdateBody;
import com.pismo.pismotransactions.dto.response.UserResponse;

public interface UserService {

    UserResponse save(UserPostBody userPostBody);

    UserResponse update(long idUser, UserUpdateBody userUpdateBody);

    UserResponse findById(long id);
}
