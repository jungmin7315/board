package com.nc13.board.model.dto;

import com.nc13.board.model.Enum.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
