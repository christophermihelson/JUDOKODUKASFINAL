package com.skzenpackage.controller;

import com.skzenpackage.service.traininggroup.GroupService;
import com.skzenpackage.service.traininggroup.classes.FullGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("intraweb")
@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/newgroup")
    public void addNewMember(@RequestBody FullGroup group) {
        groupService.addGroup(group);
    }

    @DeleteMapping("/deletegroup/{groupid}")
    public void deleteGroup(@PathVariable("groupid") Long gid) {
        groupService.deleteSingleGroup(gid);
    }

    @GetMapping("/allgroups")
    public List<FullGroup> showAllGroupss() {
        return groupService.getAllGroups();
    }

    @PatchMapping("/update/group/{groupid}")
    public void updateSingleGroup(@RequestBody FullGroup group,
                                       @PathVariable("groupid") Long gid) {
        groupService.updateSingleGroup(group, gid);
    }

}
