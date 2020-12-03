package com.skzenpackage.RowMapper;

import com.skzenpackage.Service.MemberID;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberIDRowMapper implements RowMapper<MemberID> {

    @Override
    public MemberID mapRow(ResultSet resultSet, int i) throws SQLException {
        MemberID memberID = new MemberID();
        memberID.setMemberID(resultSet.getLong("member_id"));
        return memberID;
    }
}
