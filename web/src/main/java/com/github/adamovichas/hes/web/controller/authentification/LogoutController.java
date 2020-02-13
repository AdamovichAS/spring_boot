package com.github.adamovichas.hes.web.controller.authentification;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.web.utils.WebAuthenticationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class LogoutController {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

    @GetMapping(value = "/logout_custom")
    public String logout(HttpServletRequest req) {
        final AuthUserDto principal = WebAuthenticationUtils.getPrincipalUserInSession();
        SecurityContextHolder.clearContext();
        try {
            req.logout();
        } catch (ServletException e) {
            log.error("User id: {} unable to log out at: {}", principal.getId(), LocalDateTime.now());
            throw new RuntimeException();
        }
        req.setAttribute("message", "logout.user");
        log.info("User id: {} logged out at: {}", principal.getId(), LocalDateTime.now());
        return "login_form";
    }
}