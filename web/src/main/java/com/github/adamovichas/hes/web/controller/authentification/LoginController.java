package com.github.adamovichas.hes.web.controller.authentification;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.service.IUserAccountService;
import com.github.adamovichas.hes.web.utils.WebAuthenticationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final IUserAccountService userAccountService;

    public LoginController(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public String loginGetMethod() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return "login_form";
        }
        return "redirect:/user/";
    }

    @PostMapping
    public String loginPostMethod(@RequestParam(value = "login") String login,
                                  @RequestParam(value = "password") String password,
                                  ModelMap modelMap) {
        AuthUserDto userFromDB = userAccountService.loginAuthUser(new AuthUserDto(login, password));
        if (userFromDB == null) {
            modelMap.addAttribute("message", "wrong.logpass");
            log.info("Invalid login or password enter for user: {} at: {}", login, LocalDateTime.now());
            return "login_form";
        }

        if (!userFromDB.isActive()) {
            modelMap.addAttribute("message", "inactive");
            log.info("Inactive user: {} tried to login at: {}", login, LocalDateTime.now());
            return "login_form";
        }

        WebAuthenticationUtils.setUserInSession(userFromDB);
        log.info("User: {} logged in at: {}", login, LocalDateTime.now());
        return "redirect:/user/";
    }


}
