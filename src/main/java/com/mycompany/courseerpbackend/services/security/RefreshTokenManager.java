package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.constants.TokenConstants;
import com.mycompany.courseerpbackend.models.dto.RefreshTokenDto;
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

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>,
        TokenReader<Claims>, EmailGetter {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(RefreshTokenDto obj) {

        final User user = obj.getUser();

        Claims claims = Jwts.claims();
        claims.put("email", user.getEmail());
        claims.put("type", "REFRESH_TOKEN");

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String typeOfToken = claims.get("type", String.class);

        if (!"REFRESH_TOKEN".equals(typeOfToken)) {
            throw new RuntimeException("Invalid type of token");
        }

        return claims;
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(TokenConstants.EMAIL_KEY, String.class);
    }
}
