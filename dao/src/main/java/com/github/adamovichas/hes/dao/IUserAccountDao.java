package com.github.adamovichas.hes.dao;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountDto;

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
