package com.skzenpackage.repository;

import com.skzenpackage.service.member.classes.AddMember;
import com.skzenpackage.service.traininggroup.classes.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GroupRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void addNewGroup(AddGroup group) {
        String sql = "INSERT INTO group (title, location, instructor_id)" +
                "VALUES (:title, :location, :instructor_id," +
                ":level, :phone, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", group.getTitle());
        paramMap.put("location", group.getLocation());
        paramMap.put("instructor_id", group.getInstructorID());
        jdbcTemplate.update(sql, paramMap);
    }

}
