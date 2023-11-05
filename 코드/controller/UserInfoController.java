package com.example.people.controller;

import com.example.people.entity.UserInfo;
import com.example.people.repository.UserInfoRepository;
import com.example.people.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @RequestMapping("/userinfo")
    public String showForm(Model model){
        System.out.println("show...");
        UserInfo userInfo = new UserInfo();
        model.addAttribute("userinfo",userInfo);
        return "view/userinfo";
    }
}
