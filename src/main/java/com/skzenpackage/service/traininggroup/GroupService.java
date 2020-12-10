package com.skzenpackage.service.traininggroup;

import com.skzenpackage.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepo groupRepo;


}
