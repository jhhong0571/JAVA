package com.example.o2o.controller;

import com.example.o2o.domain.Member;
import com.example.o2o.entity.Information;
import com.example.o2o.entity.Rest;
import com.example.o2o.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){this.memberService=memberService;}

    @GetMapping("/info")
    public String info(Model model, Principal principal){
        Information info = memberService.getInformationById(principal.getName());
        //System.out.println(info.getId());
        model.addAttribute("info", info);
        return "/info";
    }
    @GetMapping("/info/edit")
    public String edit(Model model,Principal principal){
        Information info = memberService.getInformationById(principal.getName());
        model.addAttribute("info", info);
        return "/infoedit";
    }
    @PostMapping("/info/edit")
    public String edito(@ModelAttribute Information info, Principal principal){
        memberService.infochange(principal.getName(), info.getPhone(), info.getMail());
        return "redirect:/info";
    }
    @GetMapping("/info/pwedit")
    public String pwedit(Model model,Principal principal){
        Member mem = memberService.getMemberById(principal.getName());
        model.addAttribute("mem", mem);
        return "/pwedit";
    }
    @PostMapping("/info/pwedit")
    public String pwedito(@ModelAttribute Member member, Principal principal){
        memberService.pwchange(principal.getName(), member.getPassword());
        return "redirect:/info";
    }
    @GetMapping("/rest")
    public String rest(Model model, Principal principal){
        List<Rest> rest = memberService.getAllMemsRest(principal.getName());
        model.addAttribute("rest",rest);
        return "rest";
    }
    @GetMapping("/rest/add")
    public String restadd(Model model){
        model.addAttribute("rest",new Rest());
        return "restadd";
    }
    @PostMapping("/rest/add")
    public String restad(Rest rest,Principal principal){
        rest.setAccept("N");
        rest.setMemId(principal.getName());
        memberService.createRest(rest);
        return "redirect:/rest";
    }

    @GetMapping("/rest/delete/{id}")
    public String deleteUser(@PathVariable("id") Long Id) {
        memberService.deleteRest(Id);
        return "redirect:/rest";
    }
}


