package com.skzenpackage.Service.Member;

import com.skzenpackage.Repository.MemberRepo;
import com.skzenpackage.Service.Member.Classes.AddMember;
import com.skzenpackage.Service.Member.Classes.FullMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepo memberRepo;

    public FullMember getSingleMember(Long memberID) {
        return memberRepo.getSingleMember(memberID);
    }

    public void addSingleMember(AddMember member) {
        memberRepo.addNewMember(member);
    }

    public void deleteSingleMember(Long memberID) {
        memberRepo.deleteMember(memberID);
    }

    public void updateSingleMember(AddMember member, Long id) {
        FullMember updatedMember = new FullMember();
        updatedMember.setMemberID(id);
        updatedMember.setFirstName(member.getFirstName());
        updatedMember.setLastName(member.getLastName());
        updatedMember.setBirthDate(member.getBirthDate());
        updatedMember.setLevel(member.getLevel());
        updatedMember.setEmail(member.getEmail());
        updatedMember.setPhone(member.getPhone());
        memberRepo.updateSingleMember(updatedMember);
    }

    public List<FullMember> getAllMembers() {
        return memberRepo.showAllMembers();
    }

    public void updateAllMembers(List<FullMember> memberList) {
        for (FullMember member : memberList) {
            memberRepo.updateSingleMember(member);
        }
    }
}