package com.mycompany.courseerpbackend.filters;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.services.language.LanguageService;
import com.mycompany.courseerpbackend.services.security.AccessTokenManager;
import com.mycompany.courseerpbackend.services.security.AuthBusinessService;
import com.mycompany.courseerpbackend.services.user.UserService;
import com.mycompany.courseerpbackend.utils.RequestStorage;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static com.mycompany.courseerpbackend.constants.TokenConstants.PREFIX;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final AuthBusinessService authBusinessService;
    private final RequestStorage requestStorage;
    private final UserService userService;
    private final LanguageService languageService;

    // I think, if exceptions thrown by methods called in doFilterInternal, spring translate it as
    // InsufficientAuthenticationException. So this AuthenticationException is handled by
    // AuthenticationEntryPoint in SecurityConfig class.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

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
        setRequestStorage();
        filterChain.doFilter(request, response);
    }

    public void setRequestStorage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // TODO: (IT) userId can be set from Claims of token, and userLanguageId from UserConfig.
            //  And userLanguageId can be set from request header like:
            //  requestDataStorage.setLangId(request.getHeader("X-Language-ID"));
            requestStorage.setUserId(userService.getByEmail(userDetails.getUsername()).getId());
            requestStorage.setUserLanguageId(languageService.getDefaultLanguage().getId());
        } else {
            requestStorage.setUserId(0L);
            requestStorage.setUserLanguageId(languageService.getDefaultLanguage().getId());
        }
    }

}
