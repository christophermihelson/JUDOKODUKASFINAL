package com.skzenpackage.controller;

import com.skzenpackage.service.member.classes.AddMember;
import com.skzenpackage.service.member.classes.FullMember;
import com.skzenpackage.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/intraweb")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/newmember")
    public void addNewMember(@RequestBody AddMember member) {
        memberService.addSingleMember(member);
    }


    @DeleteMapping("/deletemember/{memberid}")
    public void deleteMember(@PathVariable("memberid") Long mid) {
        memberService.deleteSingleMember(mid);
    }


    @GetMapping("/allmembers")
    public List<FullMember> showAllMembers() {
        return memberService.getAllMembers();
    }


    @PatchMapping("/updatemembers")
    public void updateAllMembers(@RequestBody List<FullMember> memberList) {
        memberService.updateAllMembers(memberList);
    }


    @PatchMapping("/update/member/{memberid}")
    public void updateSingleMembers(@RequestBody AddMember member,
                                 @PathVariable("memberid") Long mid) {
        memberService.updateSingleMember(member, mid);
    }






}
