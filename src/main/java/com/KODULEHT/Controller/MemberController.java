package com.KODULEHT.Controller;

import com.KODULEHT.Classes.AddMember;
import com.KODULEHT.Classes.DeleteMember;
import com.KODULEHT.Classes.FullMember;
import com.KODULEHT.Classes.MemberID;
import com.KODULEHT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RequestMapping ("intraweb")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping ("/newmember")
    public void addNewMember (@RequestBody AddMember member){
        memberService.addSingleMember(member);
    }

    @CrossOrigin
    @DeleteMapping ("/deletemember/{memberid}")
    public void deleteMember (@PathVariable("memberid") Long mid){
        memberService.deleteSingleMember(mid);
    }

    @CrossOrigin
    @GetMapping ("/allmembers")
    public List<FullMember> showAllMembers (){
        return memberService.getAllMembers();
    }

    @CrossOrigin
    @PatchMapping ("/updatemembers")
    public void updateAllMembers (@RequestBody List<FullMember> memberList){
        memberService.updateAllMembers(memberList);
    }

    // @GetMapping ("/singlemember?id=id")
    // public FullMember showSingleMember (@RequestParam) {
    //
    // }

}
