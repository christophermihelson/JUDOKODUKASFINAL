package com.KODULEHT.Controller;

import com.KODULEHT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("intraweb")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping ("/newmember")
    public void addNewMember (@RequestBody AddMember member){
        memberService.addNewMember(member);
    }

    @DeleteMapping ("/deletemember")
    public void deleteMember (@RequestBody DeleteMember member){
        memberService.deleteMember(member);
    }

    @GetMapping ("/allmembers")
    public List<FullMember> showAllMembers (){
        return memberService.showAllMembers();
    }

}
