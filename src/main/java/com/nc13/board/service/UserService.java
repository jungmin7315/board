package com.nc13.board.service;

import com.nc13.board.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean emailCheck(String email);
    void register(UserDTO userDTO);
}
