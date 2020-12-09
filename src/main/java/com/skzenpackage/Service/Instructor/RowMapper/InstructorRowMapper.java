package com.skzenpackage.Service.Instructor.RowMapper;

import com.skzenpackage.Service.Instructor.Classes.FullInstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;


public class InstructorRowMapper implements RowMapper<FullInstructor> {


    @Override
    public FullInstructor mapRow(ResultSet resultSet, int i) throws SQLException {

        FullInstructor instructor = new FullInstructor();
        instructor.setInstructorID(resultSet.getLong("instructor_id"));
        instructor.setFirstName(resultSet.getString("first_name"));
        instructor.setLastName(resultSet.getString("last_name"));

        // Andmebaasi Timestamp convert to Java LocalDate

        Timestamp a = resultSet.getTimestamp("birth_date");
        if (a == null) {
            instructor.setBirthDate(null);
        } else {
            instructor.setBirthDate(a.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }

        instructor.setLevel(resultSet.getString("level"));
        instructor.setPhone(resultSet.getString("phone"));
        instructor.setEmail(resultSet.getString("email"));
        return instructor;
    }
}
