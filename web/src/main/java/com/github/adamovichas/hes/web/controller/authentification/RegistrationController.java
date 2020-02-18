package com.github.adamovichas.hes.web.controller.authentification;

import com.github.adamovichas.hes.model.UserAccountDto;
import com.github.adamovichas.hes.service.IUserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

public class RegistrationController {

    private final IUserAccountService userAccountService;

    public RegistrationController(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = "/registration")
    public ModelAndView createNewUserAccountGet(ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUserAccountPost(@Valid UserAccountDto userAccountDto,
                                                 BindingResult br){
        final ModelAndView modelAndView = new ModelAndView("registration");
        if (br.hasFieldErrors()) {
            final String errorMessage = br.getFieldError().getDefaultMessage();
            modelAndView.addObject("message", errorMessage);
            return modelAndView;
        }
        final String message = userAccountService.addUserAccount(userAccountDto);
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
