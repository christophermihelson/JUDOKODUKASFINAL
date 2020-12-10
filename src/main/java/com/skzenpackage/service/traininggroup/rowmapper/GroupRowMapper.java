package com.skzenpackage.service.traininggroup.rowmapper;

import com.skzenpackage.service.traininggroup.classes.FullGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<FullGroup> {

    @Override
    public FullGroup mapRow(ResultSet resultSet, int i) throws SQLException {
        FullGroup group = new FullGroup();
        group.setGroupID(resultSet.getLong("group_id"));
        group.setTitle(resultSet.getString("title"));
        group.setLocation(resultSet.getString("location"));
        group.setInstructorID(resultSet.getLong("instructor_id"));
        return group;
    }
}
