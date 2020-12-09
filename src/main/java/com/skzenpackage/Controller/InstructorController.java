package com.skzenpackage.Controller;

import com.skzenpackage.Service.Instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("intraweb")
@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;

}
