package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public UserDto create(UserDto dto) {
        User user = toEntity(dto);
        return toDTO(repository.save(user));
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private UserDto toDTO(User p) {
        return UserDto.builder()
                .id(p.getId())
                .name(p.getName())
                .lastname(p.getLastname())
                .identitycard(p.getIdentitycard())
                .build();
    }

    private User toEntity(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .identitycard(dto.getIdentitycard())
                .build();
    }

}
