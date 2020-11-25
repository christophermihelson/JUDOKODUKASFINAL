package com.KODULEHT.Service;

import com.KODULEHT.Classes.Member;
import com.KODULEHT.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    Repository repository;

    public void addNewMember (Member member) {
        repository.addNewMember(member);
    }

    public void deleteMember (Member member) {
        repository.deleteMember(member.getMemberID());
    }
}
