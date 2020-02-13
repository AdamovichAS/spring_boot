package com.github.adamovichas.hes.dao.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.dao.repository.AuthUserRepository;

public class UserAccountDao implements IUserAccountDao {

    private final AuthUserRepository userAccountRepository;

    public UserAccountDao(AuthUserRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
}
