package com.github.adamovichas.hes.web.controller.authentification.service;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.Role;
import com.github.adamovichas.hes.service.IUserAccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {


    private final IUserAccountService userAccountService;

    public MyUserDetailService(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        final AuthUserDto authUserDto = userAccountService.findByUserName(userName);
        if(authUserDto == null){
            throw new UsernameNotFoundException(String.format("User %s not found",userName));
        }
        final List<GrantedAuthority> authorities = getAuthorities(authUserDto.getRole());
        return buildUserForAuthentication(authUserDto,authorities);
    }

    private List<GrantedAuthority> getAuthorities(Role role) {
        switch (role) {
            case USER:
                return Collections.singletonList((GrantedAuthority) () -> "ROLE_USER");
            case ADMIN:
                return Collections.singletonList((GrantedAuthority) () -> "ROLE_ADMIN");
            default:
                throw new RuntimeException("Wrong role");
        }
    }

    private UserDetails buildUserForAuthentication(AuthUserDto user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                true, true, true, user.isActive(), authorities);
    }
}
