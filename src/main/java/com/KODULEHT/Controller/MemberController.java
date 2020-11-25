package com.KODULEHT.Controller;

import com.KODULEHT.Classes.Member;
import com.KODULEHT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("intraweb")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping ("/newmember")
    public void addNewMember (@RequestBody Member member){
        memberService.addNewMember(member);
    }

    @DeleteMapping ("/deletemember")
    public void deleteMember (@RequestBody Member member){
        memberService.deleteMember(member);
    }

}
