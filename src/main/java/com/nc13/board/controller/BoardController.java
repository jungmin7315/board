package com.nc13.board.controller;

import com.nc13.board.model.dto.BoardDTO;
import com.nc13.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("boards")
    public String showAll(Model model){

        return "/boards";
    }
}
