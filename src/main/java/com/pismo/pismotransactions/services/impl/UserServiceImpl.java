package com.pismo.pismotransactions.services.impl;

import com.pismo.pismotransactions.dto.request.UserPostBody;
import com.pismo.pismotransactions.dto.request.UserUpdateBody;
import com.pismo.pismotransactions.dto.response.UserResponse;
import com.pismo.pismotransactions.exception.TransactionException;
import com.pismo.pismotransactions.mapper.UserMapper;
import com.pismo.pismotransactions.model.User;
import com.pismo.pismotransactions.repository.UserRepository;
import com.pismo.pismotransactions.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponse save(UserPostBody userPostBody) {
        User userSaved = userRepository.save(UserMapper.INSTANCE.toEntity(userPostBody));
        return UserMapper.INSTANCE.toDTO(userSaved);
    }

    @Override
    public UserResponse update(long idUser, UserUpdateBody userUpdateBody) {
        User userSaved = userRepository.findById(idUser)
                .orElseThrow(() -> new TransactionException("User not found with id: " + idUser));

        userSaved.setName(userUpdateBody.getName());
        userSaved.setEmail(userUpdateBody.getEmail());
        return UserMapper.INSTANCE.toDTO(userRepository.save(userSaved));
    }

    @Override
    public UserResponse findById(long id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new TransactionException("User not founded"));

        return UserMapper.INSTANCE.toDTO(user);
    }
}
