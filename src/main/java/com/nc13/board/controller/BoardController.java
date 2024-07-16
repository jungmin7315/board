package com.nc13.board.controller;

import com.nc13.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;
}
