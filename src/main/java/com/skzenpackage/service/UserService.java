package com.skzenpackage.service;

import com.skzenpackage.repository.UserRepo;
import com.skzenpackage.security.SiteUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(SiteUser siteUser) {
        String encodedPassword = passwordEncoder.encode(siteUser.getUserPassword());
        siteUser.setUserPassword(encodedPassword);
        userRepo.registerSiteUser(siteUser);
    }

    public String validateUser (SiteUser siteUser) {
        String encodedPassword = userRepo.getUserPassword(siteUser.getUserName());

        if (passwordEncoder.matches(siteUser.getUserPassword(), encodedPassword)) {

            Date now = new Date();
            JwtBuilder builder = Jwts.builder()
                    .setExpiration(new Date(now.getTime()+1000*60*60*24))
                    .setIssuedAt(now)
                    .setIssuer("issuer")
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .claim("userName", siteUser.getUserName());
            String jwt = builder.compact();
            return jwt;

        } else {
            return "Viga. Vale parool või kasutajanimi";
        }
    }



}
