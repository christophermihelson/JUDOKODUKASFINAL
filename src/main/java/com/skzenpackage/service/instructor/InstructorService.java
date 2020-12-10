package com.skzenpackage.service.instructor;

import com.skzenpackage.repository.InstructorRepo;
import com.skzenpackage.service.instructor.classes.AddInstructor;
import com.skzenpackage.service.instructor.classes.FullInstructor;
import com.skzenpackage.service.member.classes.AddMember;
import com.skzenpackage.service.member.classes.FullMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    InstructorRepo instructorRepo;

    public void addSingleInstructor(AddInstructor instructor) {
        instructorRepo.addNewInstructor(instructor);
    }

    public void deleteSingleInstructor(Long instructorID) {
        instructorRepo.deleteInstructor(instructorID);
    }

    public void updateSingleInstructor(AddInstructor instructor, Long id) {
        FullInstructor updatedInstructor = new FullInstructor();
        updatedInstructor.setInstructorID(id);
        updatedInstructor.setFirstName(instructor.getFirstName());
        updatedInstructor.setLastName(instructor.getLastName());
        updatedInstructor.setBirthDate(instructor.getBirthDate());
        updatedInstructor.setLevel(instructor.getLevel());
        updatedInstructor.setEmail(instructor.getEmail());
        updatedInstructor.setPhone(instructor.getPhone());
        instructorRepo.updateSingleInstructor(updatedInstructor);
    }
    public List<FullInstructor> getAllInstructors() {
        return instructorRepo.showAllInstructors();
    }
}