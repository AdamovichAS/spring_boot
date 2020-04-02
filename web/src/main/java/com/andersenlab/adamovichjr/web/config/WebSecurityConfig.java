package com.andersenlab.adamovichjr.web.config;

import com.andersenlab.adamovichjr.web.controller.authentification.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
//@EnableConfigurationProperties
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailService userDetailService;

    private final PasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(MyUserDetailService userDetailService, PasswordEncoder bCryptPasswordEncoder) {
        this.userDetailService = userDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http

                .authorizeRequests()
                .antMatchers(loginPage,"/registration/","/authenticate").permitAll()
                .antMatchers("/user","/").hasAnyRole("ADMIN","USER","GRAND_ADMIN")
                .antMatchers("/user/{id}").hasAnyRole("ADMIN","GRAND_ADMIN")
                .antMatchers("/user/new","/user/{id}/edit").hasAnyRole("GRAND_ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(loginPage)
 //               .loginPage("/")
                .failureUrl("/login_error")
                .defaultSuccessUrl("/user")
                .usernameParameter("user_name")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl(loginPage).and().exceptionHandling();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

}
