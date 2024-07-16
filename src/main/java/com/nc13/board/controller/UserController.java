package com.nc13.board.controller;

import com.nc13.board.model.dto.UserDTO;
import com.nc13.board.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/users/signIn")
    public String signIn(){
        return "/users/signIn";
    }

    @GetMapping("/users/signUp")
    public String signUp(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "/users/signUp";
    }

    @PostMapping("/users")
    public String register(UserDTO userDTO){
        userService.save(userDTO);
        return "redirect:/boards";
    }
}
