package com.example.firstproject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // URL 요청 접수
    public String niceToMeetYou(Model model) { // model 객체 받아오기
        model.addAttribute("username", "hongpark");
        return "greetings";
    }

    @GetMapping("/bye")  //URL 요청 접수
    public String seeYouNext(Model model) { // 모델 객체 받아오기
        model.addAttribute("nickname", "홍길동"); // 모델 변수 등록
        return "goodbye"; //goodbye.mustache 반환
    }

}
