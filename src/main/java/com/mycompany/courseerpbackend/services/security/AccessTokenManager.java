package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.properties.security.SecurityProperties;
import com.mycompany.courseerpbackend.services.base.TokenGenerator;
import com.mycompany.courseerpbackend.services.base.TokenReader;
import com.mycompany.courseerpbackend.services.getters.EmailGetter;
import com.mycompany.courseerpbackend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.mycompany.courseerpbackend.constants.TokenConstants.EMAIL_KEY;

@Component // I think it will be @Service
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User>,
        TokenReader<Claims>, EmailGetter {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(User obj) {

        Claims claims = Jwts.claims();
        claims.put(EMAIL_KEY, obj.getEmail());

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                // signed with Private Key to secure token
                .compact();
    }

    @Override
    public Claims read(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey()) // setting Public Key to verify signed token
                .build()
                .parseClaimsJws(token) // parseClaimsJws() for signed JWTs, parseClaimsJwt() for unsigned JWTs
                .getBody();
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(EMAIL_KEY, String.class);
    }
}
