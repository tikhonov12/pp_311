package com.jm.pp_311.controller;

import com.jm.pp_311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jm.pp_311.service.UserService;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authenticated")
    public String pageForAuth(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoleSet());
        return "userData";
    }

}
