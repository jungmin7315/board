package com.nc13.board.service;

import com.nc13.board.model.Enum.UserRole;
import com.nc13.board.model.dto.UserDTO;
import com.nc13.board.model.entity.UsersEntity;
import com.nc13.board.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UsersEntity users = UsersEntity.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .role(UserRole.ROLE_USER)
                .build();
        usersRepository.save(users);
    }
}
