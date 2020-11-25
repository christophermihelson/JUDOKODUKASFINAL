package com.KODULEHT.Service;

import com.KODULEHT.Controller.AddMember;
import com.KODULEHT.Controller.DeleteMember;
import com.KODULEHT.Controller.FullMember;
import com.KODULEHT.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    Repository repository;

    public void addNewMember (AddMember member) {
        repository.addNewMember(member);
    }

    public void deleteMember (DeleteMember member) {
        repository.deleteMember(member.getMemberID());
    }

    public List<FullMember> showAllMembers () {
        return repository.showAllMembers();
    }
}
