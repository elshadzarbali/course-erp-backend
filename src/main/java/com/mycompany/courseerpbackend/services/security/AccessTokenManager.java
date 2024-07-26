package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.properties.security.SecurityProperties;
import com.mycompany.courseerpbackend.services.base.TokenGenerator;
import com.mycompany.courseerpbackend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // I think it will be @Service
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User> {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(User obj) {

        Claims claims = Jwts.claims().add("email", obj.getEmail()).build();

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }


}
