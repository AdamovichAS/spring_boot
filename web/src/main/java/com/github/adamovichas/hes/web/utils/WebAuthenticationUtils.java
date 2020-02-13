package com.github.adamovichas.hes.web.utils;

import com.github.adamovichas.hes.model.AuthUserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class WebAuthenticationUtils {
    private WebAuthenticationUtils() {
    }

    public static AuthUserDto getPrincipalUserInSession() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (AuthUserDto) authentication.getPrincipal();
    }
}
