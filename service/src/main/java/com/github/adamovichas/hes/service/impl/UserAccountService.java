package com.github.adamovichas.hes.service.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.service.IUserAccountService;

public class UserAccountService implements IUserAccountService {

    private final IUserAccountDao userAccountDao;

    public UserAccountService(IUserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @Override
    public AuthUserDto loginAuthUser(AuthUserDto authUser) {
        AuthUserDto userFromDB = userAccountDao.getByLogin(authUser.getUserName());
        boolean isValidPassword = false;
        if (userFromDB != null) {
            isValidPassword =
                    authUser.getPassword().equals(userFromDB.getPassword());
        }
        return (isValidPassword) ? userFromDB : null;
    }
}
