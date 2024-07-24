package com.nc13.board.service;

import com.nc13.board.model.Enum.UserRole;
import com.nc13.board.model.dto.UserDTO;
import com.nc13.board.model.entity.UsersEntity;
import com.nc13.board.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean emailCheck(String email) {
        UsersEntity user = usersRepository.findByEmail(email);
        if(user != null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    @Transactional
    public void register(UserDTO userDTO) {
        UsersEntity users = UsersEntity.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .name(userDTO.getName())
                .role(UserRole.ROLE_USER)
                .build();
        usersRepository.save(users);
    }
}
