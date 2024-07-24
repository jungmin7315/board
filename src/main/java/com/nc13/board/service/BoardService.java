package com.nc13.board.service;

import com.nc13.board.model.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    Page<BoardDTO> getAll(int page);
    BoardDTO findById(long id);
}
