package com.skzenpackage.Repository;
import com.skzenpackage.Service.Member.RowMapper.MemberIDRowMapper;
import com.skzenpackage.Service.Member.RowMapper.MemberRowMapper;
import com.skzenpackage.Service.Member.Classes.AddMember;
import com.skzenpackage.Service.Member.Classes.FullMember;
import com.skzenpackage.Service.Member.Classes.MemberByID;
import com.skzenpackage.Service.Payment.NewPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void getMemberByID(Long memberID) {
        String sql = "SELECT FROM member WHERE member_id = :mid";
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("mid", memberID);
        jdbcTemplate.queryForObject(sql, paramMap, new MemberRowMapper());
    }

    public void addNewMember(AddMember member) {
        String sql = "INSERT INTO member (first_name, last_name, birth_date," +
                "level, phone, email) VALUES (:first, :last, :birthdate," +
                ":level, :phone, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first", member.getFirstName());
        paramMap.put("last", member.getLastName());
        paramMap.put("birthdate", member.getBirthDate());
        paramMap.put("level", member.getLevel());
        paramMap.put("phone", member.getPhone());
        paramMap.put("email", member.getEmail());
        jdbcTemplate.update(sql, paramMap);
    }

    public void deleteMember(Long memberID) {
        String sql = "DELETE FROM member WHERE member_id = :mid";
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("mid", memberID);
        jdbcTemplate.update(sql, paramMap);
    }


    public List<FullMember> showAllMembers() {
        String sql = "SELECT * FROM member";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new MemberRowMapper());
    }

    public FullMember getSingleMember(Long memberID) {
        String sql = "SELECT * FROM member WHERE member_id = :mid";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("mid", memberID);
        return jdbcTemplate.queryForObject(sql, paramMap, new MemberRowMapper());
    }

    public List<MemberByID> getAllMemberIDs() {
        String sql = "SELECT member_id FROM member";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new MemberIDRowMapper());
    }

    public void updateSingleMember(FullMember member) {
        String outputSQL = "UPDATE member SET first_name = :first, last_name = :last," +
                "birth_date = :birth, level = :level, phone = :phone, email = :email" +
                " WHERE member_id = :mid";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("mid", member.getMemberID());
        paramMap.put("first", member.getFirstName());
        paramMap.put("last", member.getLastName());
        paramMap.put("birth", member.getBirthDate());
        paramMap.put("level", member.getLevel());
        paramMap.put("phone", member.getPhone());
        paramMap.put("email", member.getEmail());
        jdbcTemplate.update(outputSQL, paramMap);

    }
}