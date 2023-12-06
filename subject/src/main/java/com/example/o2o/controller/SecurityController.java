package com.example.o2o.controller;

import com.example.o2o.domain.Member;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.o2o.service.*;

import java.security.Principal;


@Controller
public class SecurityController {
    @GetMapping("/")
    public String index(Principal principal, Model model) {
        System.out.println("indexlogin 요청입니다.");
        if(principal!=null) {
            String name = principal.getName();
            System.out.println(name+"님 로그인!");
            model.addAttribute("name", name);
        }
        return "index";
    }

    @GetMapping("/member")  //templates/member.html 실행
    public void forMember() {
        System.out.println("Member 요청입니다.");
    }

    @GetMapping("/manager")
    public String  forManager() {
        System.out.println("Manager 요청입니다.");
        return "/manager/manager";
    }

    @GetMapping("/admin")
    public String forAdmin() {
        System.out.println("Admin 요청입니다.");
        return "/admin/admin_page";
    }


    @GetMapping("/login") //templates/login.html 실행
    public String login() {
        return "/login";
    }

    @GetMapping("/accessDenied") //templates/accessDenied.html 실행
    public String accessDenied() {
        return "/login";
    }

    @GetMapping("/conditional-content") //templates/conditional-content.html 실행
    public void conditionalContent() {
    }

    @GetMapping("/logout_page")
    public String logout(){
        System.out.println("logout");
        return "logout_page";
    }
}
