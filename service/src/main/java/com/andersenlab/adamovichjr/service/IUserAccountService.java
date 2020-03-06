package com.andersenlab.adamovichjr.service;

import com.andersenlab.adamovichjr.model.AuthUserDto;
import com.andersenlab.adamovichjr.model.Page;
import com.andersenlab.adamovichjr.model.UserAccountDto;

public interface IUserAccountService {
    AuthUserDto findByUserName(String userName);
    Page<UserAccountDto> getUserAccountViewsOnPage(int currentPage);
    UserAccountDto getUserAccountViewById(Long id);
    String addUserAccount(UserAccountDto userAccountDto);
    String editUserAccount(UserAccountDto userAccountDto);
}
