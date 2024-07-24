package com.nc13.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController {
    @GetMapping("/error/userDuplication")
    public String userDuplication(Model model){
        model.addAttribute("message","중복된 아이디입니다.");
        return "/error/userDuplication";
    }
    @PostMapping("/error/logInFailure")
    public String logInFailure(Model model){
        model.addAttribute("message","로그인 실패");
        return "/error/logInFailure";
    }
}
