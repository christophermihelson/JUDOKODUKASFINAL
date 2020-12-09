package com.skzenpackage.Service.Instructor;

import com.skzenpackage.Repository.InstructorRepo;
import com.skzenpackage.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepo instructorRepo;



}
