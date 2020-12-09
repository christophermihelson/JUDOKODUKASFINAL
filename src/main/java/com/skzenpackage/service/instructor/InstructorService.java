package com.skzenpackage.service.instructor;

import com.skzenpackage.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepo instructorRepo;



}
