package com.example.people.controller;

import com.example.people.entity.Lecture;
import com.example.people.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class scoreController {
    @Autowired
    LectureRepository LectureRepository;

    @RequestMapping("/")
    public String home(){
        return "view/menubar";
    }
    @RequestMapping("/lectinfo")
    public String lect(){
        return "view/lectinfo";
    }
    @GetMapping("/sign")
    public String sign(Model model){
        Lecture lecture = new Lecture();
        List<Lecture> lectureList = LectureRepository.findAll();
        model.addAttribute("lectureList",lectureList);
        return "view/signinfo";
    }
    @RequestMapping("/pwchange")
    public String pwchange(Model model){
        return "view/pwchange";
    }
    @GetMapping("/score")
    public String showForm(Model model){
        Lecture lecture = new Lecture();
        List<Lecture> lectureList = LectureRepository.findAll();
        model.addAttribute("lectureList",lectureList);
        return "view/scorecheck";
    }
}
