package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto create(UserDto dto);

    UserDto update(Long id, UserDto dto);

    void delete(Long id);
}
