package com.github.adamovichas.hes.web.controller;

import com.github.adamovichas.hes.model.Page;
import com.github.adamovichas.hes.model.UserAccountDto;
import com.github.adamovichas.hes.service.IUserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserAccountController {

    private final IUserAccountService userAccountService;

    public UserAccountController(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = "")
    public ModelAndView getUsers(HttpServletRequest req){
        final ModelAndView modelAndView = new ModelAndView("main");
        String currentPage = req.getParameter("currentPage");
        if(currentPage == null){
            currentPage = "1";
        }
        int numberPage = Integer.parseInt(currentPage);
        final Page<UserAccountDto> page = userAccountService.getUserAccountViewsOnPage(numberPage);
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getUserView(@PathVariable Long id,
                                    ModelAndView modelAndView){
        modelAndView.setViewName("user_view");
        final UserAccountDto userAccountView = userAccountService.getUserAccountViewById(id);
        modelAndView.addObject("user",userAccountView);
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public ModelAndView createNewUserAccountGet(ModelAndView modelAndView){
        modelAndView.setViewName("create_user");
        return modelAndView;
    }

    @PostMapping(value = "/new")
    public ModelAndView createNewUserAccountPost(@Valid UserAccountDto userAccountDto,
                                                 BindingResult br){
        final ModelAndView modelAndView = new ModelAndView("create_user");
        if (br.hasFieldErrors()) {
            final String errorMessage = br.getFieldError().getDefaultMessage();
            modelAndView.addObject("message", errorMessage);
            return modelAndView;
        }
        final String message = userAccountService.addUserAccount(userAccountDto);
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @GetMapping(value = "/{id}/edit")
    public ModelAndView editUserAccount(@PathVariable Long id,
                                        ModelAndView modelAndView){
        final UserAccountDto userAccount = userAccountService.getUserAccountViewById(id);
        modelAndView.addObject("user",userAccount);
        modelAndView.setViewName("edit_user");
        return modelAndView;
    }

    @PostMapping(value = "/{id}/edit")
    public String editUserAccountPost(@PathVariable Long id,
                                      @Valid UserAccountDto userAccountDto,
                                      BindingResult br,
                                      RedirectAttributesModelMap redirectModelMap){
        if (br.hasFieldErrors()) {
            final String errorMessage = br.getFieldError().getDefaultMessage();
            redirectModelMap.addFlashAttribute("message", errorMessage);
            return "redirect:/user/" + id + "/edit";
        }
        final String message = userAccountService.editUserAccount(userAccountDto);
        redirectModelMap.addFlashAttribute("message",message);
        return "redirect:/user/" + id + "/edit";
    }
}
