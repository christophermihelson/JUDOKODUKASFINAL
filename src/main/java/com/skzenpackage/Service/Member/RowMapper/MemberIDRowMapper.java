package com.skzenpackage.Service.Member.RowMapper;

import com.skzenpackage.Service.Member.MemberByID;
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
