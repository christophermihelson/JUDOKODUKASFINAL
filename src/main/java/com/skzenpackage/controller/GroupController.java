package com.skzenpackage.controller;

import com.skzenpackage.service.traininggroup.GroupService;
import com.skzenpackage.service.traininggroup.classes.AddGroup;
import com.skzenpackage.service.traininggroup.classes.DisplayGroup;
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
    public void addNewMember(@RequestBody AddGroup group) {
        groupService.addGroup(group);
    }

    @DeleteMapping("/deletegroup/{groupid}")
    public void deleteGroup(@PathVariable("groupid") Long gid) {
        groupService.deleteSingleGroup(gid);
    }

    @GetMapping("/allgroups")
    public List<DisplayGroup> showAllGroups() {
        return groupService.displayAllGroupsService();
    }

    @PatchMapping("/update/group/{groupid}")
    public void updateSingleGroup(@RequestBody AddGroup group,
                                       @PathVariable("groupid") Long gid) {
        groupService.updateSingleGroup(group, gid);
    }

}
