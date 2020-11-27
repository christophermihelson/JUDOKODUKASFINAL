package com.KODULEHT.Service;

import com.KODULEHT.Classes.AddMember;
import com.KODULEHT.Classes.DeleteMember;
import com.KODULEHT.Classes.FullMember;
import com.KODULEHT.Classes.MemberID;
import com.KODULEHT.Repository.Repository;
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

    public void updateSingleMember(FullMember member) {
        repository.updateSingleMember(member);
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