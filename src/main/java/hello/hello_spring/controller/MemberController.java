package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 객체를 스프링 컨테이너가 찾아서 자동 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
