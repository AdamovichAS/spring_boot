package com.github.adamovichas.hes.web.controller.authentification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

//    @GetMapping(value = "/logout_custom")
//    public String logout(HttpServletRequest req) {
//        final AuthUserDto principal = WebAuthenticationUtils.getPrincipalUserInSession();
//        SecurityContextHolder.clearContext();
//        try {
//            req.logout();
//        } catch (ServletException e) {
//            log.error("User id: {} unable to log out at: {}", principal.getId(), LocalDateTime.now());
//            throw new RuntimeException();
//        }
//        req.setAttribute("message", "logout.user");
//        log.info("User id: {} logged out at: {}", principal.getId(), LocalDateTime.now());
//        return "login_form";
//    }
}
