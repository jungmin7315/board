package com.nc13.board.service;

import com.nc13.board.model.entity.BoardEntity;
import org.springframework.data.domain.Page;

public interface BoardService {
    Page<BoardEntity> getAll(int page);
}
