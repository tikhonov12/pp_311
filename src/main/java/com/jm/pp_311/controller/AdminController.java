package com.jm.pp_311.controller;


import com.jm.pp_311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jm.pp_311.service.RoleService;
import com.jm.pp_311.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController() {
    }

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("auth", userService.findByName(principal.getName()));
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/home";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping("/{id}/editUser")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "editUser";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id, @RequestParam("role") String role) {
        userService.updateUser(user, id, role);
        return "redirect:/admin/home";
    }

    @GetMapping("home/linkDelete")
    public String delete(@RequestParam(required = false) Long status) {
        userService.deleteById(status);
        return "redirect:/admin/home";
    }
}
