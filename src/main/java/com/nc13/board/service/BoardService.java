package com.nc13.board.service;

import com.nc13.board.model.dto.BoardDTO;
import org.springframework.data.domain.Page;

public interface BoardService {
    Page<BoardDTO> getAll(int page);
}
