package com.skzenpackage.repository;

import com.skzenpackage.service.member.rowmapper.MemberRowMapper;
import com.skzenpackage.service.payment.NewPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    public void newPaymentForSingleMemberByID(NewPayment newPayment) {
        String sql = "INSERT INTO payment (member_id, date, status) VALUES (:mid, :date, :status)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("mid", newPayment.getBelongingUserID());
        paramMap.put("date", newPayment.getPaymentDate());
        paramMap.put("status", newPayment.getPaymentStatus());
        jdbcTemplate.queryForObject(sql, paramMap, new MemberRowMapper());
    }

}
