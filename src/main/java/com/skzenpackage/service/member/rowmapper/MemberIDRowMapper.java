package com.skzenpackage.service.member.rowmapper;

import com.skzenpackage.service.member.classes.MemberByID;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberIDRowMapper implements RowMapper<MemberByID> {

    @Override
    public MemberByID mapRow(ResultSet resultSet, int i) throws SQLException {
        MemberByID memberID = new MemberByID();
        memberID.setMemberID(resultSet.getLong("member_id"));
        return memberID;
    }
}
