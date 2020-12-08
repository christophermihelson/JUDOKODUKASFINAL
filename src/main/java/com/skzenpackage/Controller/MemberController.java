package com.skzenpackage.Controller;

import com.skzenpackage.Security.SiteUser;
import com.skzenpackage.Service.Member.AddMember;
import com.skzenpackage.Service.Member.FullMember;
import com.skzenpackage.Service.Member.MemberService;
import com.skzenpackage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("intraweb")
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


    @PatchMapping("/update/{memberid}")
    public void updateSingleMembers(@RequestBody AddMember member,
                                 @PathVariable("memberid") Long mid) {
        memberService.updateSingleMember(member, mid);
    }

}
