package com.nc13.board.service;

import com.nc13.board.model.dto.BoardDTO;
import com.nc13.board.model.entity.BoardEntity;
import com.nc13.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public Page<BoardDTO> getAll(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 20, Sort.by(sorts));
        Page<BoardEntity> boardsEn = boardRepository.findAll(pageable);
        Page<BoardDTO> boards = boardsEn.map(b -> BoardDTO.builder()
                .id(b.getId())
                .title(b.getTitle())
                .content(b.getContent())
                .userName(b.getUser().getName())
                .createdAt(b.getCreatedAt())
                .updatedAt(b.getUpdatedAt())
                .build());
        return boards;
    }

    @Override
    public BoardDTO findById(long id) {
        BoardEntity boardEntity = boardRepository.findById(id);
        BoardDTO boardDTO = BoardDTO.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdAt(boardEntity.getCreatedAt())
                .updatedAt(boardEntity.getUpdatedAt())
                .userName(boardEntity.getUser().getName())
                .build();
        return boardDTO;
    }


}
