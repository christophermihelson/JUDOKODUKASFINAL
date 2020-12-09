package com.skzenpackage.Repository;

import com.skzenpackage.Service.Instructor.Classes.AddInstructor;
import com.skzenpackage.Service.Instructor.Classes.FullInstructor;
import com.skzenpackage.Service.Instructor.RowMapper.InstructorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstructorRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void addNewInstructor(AddInstructor instructor) {
        String sql = "INSERT INTO instructor (first_name, last_name, birth_date," +
                "level, phone, email) VALUES (:first, :last, :birthdate," +
                ":level, :phone, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first", instructor.getFirstName());
        paramMap.put("last", instructor.getLastName());
        paramMap.put("birthdate", instructor.getBirthDate());
        paramMap.put("level", instructor.getLevel());
        paramMap.put("phone", instructor.getPhone());
        paramMap.put("email", instructor.getEmail());
        jdbcTemplate.update(sql, paramMap);
    }

    public void deleteInstructor(Long instructorID) {
        String sql = "DELETE FROM instructor WHERE instructor_id = :iid";
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("iid", instructorID);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<FullInstructor> showAllInstructors() {
        String sql = "SELECT * FROM instructor";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new InstructorRowMapper());
    }

    public FullInstructor getSingleInstructor(Long instructorID) {
        String sql = "SELECT * FROM member WHERE instructor_id = :iid";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iid", instructorID);
        return jdbcTemplate.queryForObject(sql, paramMap, new InstructorRowMapper());
    }

}