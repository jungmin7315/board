package com.nc13.board.controller;


import com.nc13.board.model.dto.BoardDTO;
import com.nc13.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardServiceImpl boardService;

    @GetMapping("/")
    public String index(){
        return "redirect:/boards";
    }

    @GetMapping("/boards")
    public String showAll(Model model, @RequestParam(value = "page" , defaultValue = "0")int page){
        Page<BoardDTO> paging = boardService.getAll(page);
        model.addAttribute("paging",paging);
        return "/boards";
    }
}
