package com.mycompany.courseerpbackend.filters;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.services.security.AccessTokenManager;
import com.mycompany.courseerpbackend.services.security.AuthBusinessService;
import com.mycompany.courseerpbackend.utils.RequestDataStorage;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static com.mycompany.courseerpbackend.constants.RequestConstants.USER_ID;
import static com.mycompany.courseerpbackend.constants.RequestConstants.USER_LANGUAGE;
import static com.mycompany.courseerpbackend.constants.TokenConstants.PREFIX;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final AuthBusinessService authBusinessService;
    private final RequestDataStorage requestDataStorage;

    // I think, if exceptions thrown by methods called in doFilterInternal, spring translate it as
    // InsufficientAuthenticationException. So this AuthenticationException is handled by
    // AuthenticationEntryPoint in SecurityConfig class.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        // TODO: (IT) It must be come from JWT token
        requestDataStorage.setUserId(request.getHeader(USER_ID));
        requestDataStorage.setUserLanguage(request.getHeader(USER_LANGUAGE));

        try {
            if (Objects.nonNull(token) && token.startsWith(PREFIX)) {
                authBusinessService.setAuthentication(
                        accessTokenManager.getEmail(
                                token.substring(7)
                        )
                );
            }
        } catch (BaseException | JwtException ex) {
            log.warn(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }

}
