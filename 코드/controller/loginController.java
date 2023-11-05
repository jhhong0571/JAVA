package com.example.people.controller;

import com.example.people.entity.UserInfo;
import com.example.people.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "view/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam Long id, @RequestParam String password, Model model) {
        UserInfo userinfo = userService.login(id, password);
        if (userinfo != null) {
            model.addAttribute("userinfo", userinfo);
            return "view/menubar";
        } else {
            model.addAttribute("Error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "view/login";
        }
    }
}