package com.skzenpackage.controller;

import com.skzenpackage.service.instructor.InstructorService;
import com.skzenpackage.service.instructor.classes.AddInstructor;
import com.skzenpackage.service.instructor.classes.FullInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("intraweb")
@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping("/newinstructor")
    public void addNewInstructor(@RequestBody AddInstructor instructor) {
        instructorService.addSingleInstructor(instructor);
    }

    @DeleteMapping("/deleteinstructor/{instructorid}")
    public void deleteInstructor(@PathVariable("instructorid") Long iid) {
        instructorService.deleteSingleInstructor(iid);
    }

    @GetMapping("/allinstructors")
    public List<FullInstructor> showAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PatchMapping("/update/instructor/{instructorid}")
    public void updateSingleInstructor(@RequestBody AddInstructor instructor,
                                    @PathVariable("instructorid") Long iid) {
        instructorService.updateSingleInstructor(instructor, iid);
    }

}