package com.skzenpackage.service.traininggroup;

import com.skzenpackage.repository.GroupRepo;
import com.skzenpackage.repository.InstructorRepo;
import com.skzenpackage.service.instructor.classes.FullInstructor;
import com.skzenpackage.service.traininggroup.classes.AddGroup;
import com.skzenpackage.service.traininggroup.classes.DisplayGroup;
import com.skzenpackage.service.traininggroup.classes.FullGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    InstructorRepo instructorRepo;


    public void addGroup(AddGroup group) {
        groupRepo.addNewGroup(group);
    }

    public void deleteSingleGroup(Long groupID) {
        groupRepo.deleteGroup(groupID);
    }

    public void updateSingleGroup(AddGroup group, Long groupID) {
        FullGroup updatedGroup = new FullGroup();
        updatedGroup.setInstructorID(groupID);
        updatedGroup.setLocation(group.getLocation());
        updatedGroup.setTitle(group.getTitle());
        groupRepo.updateSingleGroup(updatedGroup);
    }

    public List<DisplayGroup> displayAllGroupsService() {
        List<FullGroup> allGroups = groupRepo.getAllGroups();
        List<DisplayGroup> allDisplayGroups = new ArrayList<>();

        for (int i = 0; i < allGroups.size(); i++){
            FullGroup currentGroup = allGroups.get(i);
            Long currentInstructorID = currentGroup.getInstructorID();
            FullInstructor currentInstructor = instructorRepo.getSingleInstructor(currentInstructorID);
            String currentInstructorName = currentInstructor.getFirstName() + " " + currentInstructor.getLastName();
            DisplayGroup newGroup = new DisplayGroup();
            newGroup.setInstructorName(currentInstructorName);
            newGroup.setLocation(currentGroup.getLocation());
            newGroup.setTitle(currentGroup.getTitle());
            newGroup.setGroupID(currentGroup.getGroupID());
            allDisplayGroups.add(newGroup);
        }
        return allDisplayGroups;
    }
}
