package com.nc13.board.repository;

import com.nc13.board.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    @Query("SELECT b FROM BoardEntity b INNER JOIN b.user")
    Page<BoardEntity> findAll(Pageable pageable);
}
