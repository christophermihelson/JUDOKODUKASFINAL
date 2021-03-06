package com.skzenpackage.repository;

import com.skzenpackage.service.traininggroup.classes.AddGroup;
import com.skzenpackage.service.traininggroup.classes.FullGroup;
import com.skzenpackage.service.traininggroup.rowmapper.GroupRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void addNewGroup(AddGroup group) {
        String sql = "INSERT INTO training_group (title, location, instructor_id)" +
                "VALUES (:title, :location, :instructor_id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", group.getTitle());
        paramMap.put("location", group.getLocation());
        paramMap.put("instructor_id", group.getInstructorID());
        jdbcTemplate.update(sql, paramMap);
    }

    public void deleteGroup(Long groupID) {
        String sql = "DELETE FROM training_group WHERE group_id = :gid";
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("gid", groupID);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateSingleGroup(FullGroup updatedGroup) {
        String outputSQL = "UPDATE training_group SET title = :title, location = :loc," +
                "instructor_id = :iid WHERE group_id = :gid";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", updatedGroup.getTitle());
        paramMap.put("location", updatedGroup.getLocation());
        paramMap.put("iid", updatedGroup.getInstructorID());
        paramMap.put("gid", updatedGroup.getGroupID());
        jdbcTemplate.update(outputSQL, paramMap);
    }

    public List<FullGroup> getAllGroups() {
        String sql = "SELECT * FROM training_group";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new GroupRowMapper());
    }
}
