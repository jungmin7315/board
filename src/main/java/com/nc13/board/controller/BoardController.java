package com.nc13.board.controller;

import com.nc13.board.model.dto.BoardDTO;
import com.nc13.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;

    @GetMapping("/boards/{id}")
    public String getBoardById(@PathVariable("id") Long id, Model model) {
        BoardDTO board = boardService.findById(id);

        model.addAttribute("board",board);

        return "/boards/showOne";
    }
}
