package com.KODULEHT.Controller;

import com.KODULEHT.Classes.Member;
import com.KODULEHT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("intraweb")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping ("/newmember")
    public void addNewMember (@RequestBody Member member){
        memberService.addNewMember(member);
    }

}
