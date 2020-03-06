package com.andersenlab.adamovichjr.dao;

import com.andersenlab.adamovichjr.model.AuthUserDto;
import com.andersenlab.adamovichjr.model.UserAccountDto;

import java.util.List;

public interface IUserAccountDao {
    AuthUserDto findByUserName(String userMame);
    List<UserAccountDto> getUserAccountViewsOnPag(int currentPage, int pageSize);
    Long getCountUserAccounts();
    UserAccountDto getUserAccountDtoById(Long id);
    boolean userNameIsExist(String userName);
    void addUserAccount(UserAccountDto userAccount);
    void editUserAccount(UserAccountDto userAccount);
}
