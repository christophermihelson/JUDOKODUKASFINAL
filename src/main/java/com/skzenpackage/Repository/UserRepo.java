package com.skzenpackage.Repository;

import com.skzenpackage.Security.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void registerSiteUser (SiteUser siteuser){
        String sql = "INSERT INTO siteuser (site_username, site_userpassword) VALUES (:user, :pass)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("user", siteuser.getUserName());
        paramMap.put("pass", siteuser.getUserPassword());
        jdbcTemplate.update(sql, paramMap);
    }

    public String getUserPassword (String username){
        String sql = "SELECT site_userpassword FROM siteuser WHERE site_username = :sun";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("sun", username);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

}
