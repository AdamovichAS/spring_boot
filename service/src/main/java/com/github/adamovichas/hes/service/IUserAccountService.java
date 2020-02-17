package com.github.adamovichas.hes.service;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.Page;
import com.github.adamovichas.hes.model.UserAccountDto;

public interface IUserAccountService {
    AuthUserDto loginAuthUser(AuthUserDto user);
    AuthUserDto findByUserName(String userName);
    Page<UserAccountDto> getUserAccountViewsOnPage(int currentPage);
    UserAccountDto getUserAccountViewById(Long id);
    String addUserAccount(UserAccountDto userAccountDto);
    String editUserAccount(UserAccountDto userAccountDto);
}
