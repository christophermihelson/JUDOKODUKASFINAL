package com.skzenpackage.Service.Member;

import com.skzenpackage.Repository.Repository;
import com.skzenpackage.Service.Member.AddMember;
import com.skzenpackage.Service.Member.FullMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    Repository repository;

    public FullMember getSingleMember(Long memberID) {
        return repository.getSingleMember(memberID);
    }

    public void addSingleMember(AddMember member) {
        repository.addNewMember(member);
    }

    public void deleteSingleMember(Long memberID) {
        repository.deleteMember(memberID);
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
        repository.updateSingleMember(updatedMember);
    }

    public List<FullMember> getAllMembers() {
        return repository.showAllMembers();
    }

    public void updateAllMembers(List<FullMember> memberList) {
        for (FullMember member : memberList) {
            repository.updateSingleMember(member);
        }
    }
}