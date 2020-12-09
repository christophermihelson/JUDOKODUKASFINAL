package com.skzenpackage.service.member.rowmapper;

import com.skzenpackage.service.member.classes.FullMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;

public class MemberRowMapper implements RowMapper<FullMember> {


    @Override
    public FullMember mapRow(ResultSet resultSet, int i) throws SQLException {
        FullMember member = new FullMember();
        member.setMemberID(resultSet.getLong("member_id"));
        member.setFirstName(resultSet.getString("first_name"));
        member.setLastName(resultSet.getString("last_name"));

        // Andmebaasi Timestamp convert to Java LocalDate

        Timestamp a = resultSet.getTimestamp("birth_date");
        if (a == null){
            member.setBirthDate(null);
        } else {
            member.setBirthDate(a.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }

        member.setLevel(resultSet.getString("level"));
        member.setPhone(resultSet.getString("phone"));
        member.setEmail(resultSet.getString("email"));
        return member;
    }


}
