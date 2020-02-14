package com.github.adamovichas.hes.dao;

import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountView;

import java.util.List;

public interface IUserAccountDao {
    AuthUserDto getByLogin(String userMame);
    List<UserAccountView> getUserAccountViewsOnPag(int currentPage, int pageSize);
    Long getCountUserAccounts();
}
