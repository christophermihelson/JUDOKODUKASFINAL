package com.skzenpackage.service.traininggroup;

import com.skzenpackage.repository.GroupRepo;
import com.skzenpackage.service.instructor.classes.AddInstructor;
import com.skzenpackage.service.instructor.classes.FullInstructor;
import com.skzenpackage.service.traininggroup.classes.FullGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepo groupRepo;

    public void addGroup(FullGroup group) {
        groupRepo.addNewGroup(group);
    }

    public void deleteSingleGroup(Long groupID) {
        groupRepo.deleteGroup(groupID);
    }

    public void updateSingleGroup(FullGroup group, Long groupID) {
        FullGroup updatedGroup = new FullGroup();
        updatedGroup.setInstructorID(groupID);
        updatedGroup.setLocation(group.getLocation());
        updatedGroup.setTitle(group.getTitle());
        groupRepo.updateSingleGroup(updatedGroup);
    }
    public List<FullGroup> getAllGroups() {
        return groupRepo.showAllGroups();
    }


}
