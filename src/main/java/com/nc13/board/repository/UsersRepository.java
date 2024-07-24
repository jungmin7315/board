package com.nc13.board.repository;

import com.nc13.board.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByEmail(String email);
}
