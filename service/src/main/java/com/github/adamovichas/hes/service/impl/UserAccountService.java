package com.github.adamovichas.hes.service.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.Page;
import com.github.adamovichas.hes.model.UserAccountDto;
import com.github.adamovichas.hes.service.IUserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

public class UserAccountService implements IUserAccountService {

    private static final int PAGE_SIZE = 5;
    private final IUserAccountDao userAccountDao;
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserAccountService(IUserAccountDao userAccountDao, PasswordEncoder bCryptPasswordEncoder) {
        this.userAccountDao = userAccountDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AuthUserDto loginAuthUser(AuthUserDto authUser) {
        AuthUserDto userFromDB = userAccountDao.getByUserName(authUser.getUserName());
        boolean isValidPassword = false;
        if (userFromDB != null) {
            isValidPassword =
                    authUser.getPassword().equals(userFromDB.getPassword());
        }
        return (isValidPassword) ? userFromDB : null;
    }

    @Override
    public AuthUserDto findByUserName(String userName) {
        return userAccountDao.getByUserName(userName);
    }

    @Override
    public Page<UserAccountDto> getUserAccountViewsOnPage(int currentPage) {
        final List<UserAccountDto> views = userAccountDao.getUserAccountViewsOnPag(currentPage, PAGE_SIZE);
        final Long countUserAccounts = userAccountDao.getCountUserAccounts();
        final Long countMaxPages = getCountMaxPages(countUserAccounts);
        return new Page<>(PAGE_SIZE,currentPage,countMaxPages,views);
    }

    private Long getCountMaxPages(Long countObjects){
        Long maxPages = countObjects / PAGE_SIZE;
        if(countObjects % PAGE_SIZE > 0){
            maxPages++;
        }
        return maxPages;
    }

    @Override
    public UserAccountDto getUserAccountViewById(Long id) {
        return userAccountDao.getUserAccountDtoById(id);
    }

    @Override
    public String addUserAccount(UserAccountDto userAccount) {
        userAccount.setCreatedAt(LocalDateTime.now());
        final boolean userNameIsExist = userAccountDao.userNameIsExist(userAccount.getUserName());
        if(userNameIsExist){
            return "A user with the same user name already exists.";
        }
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userAccountDao.addUserAccount(userAccount);
        return "A new user saved";
    }

    @Override
    public String editUserAccount(UserAccountDto userAccount) {
        final boolean userNameIsExist = userAccountDao.userNameIsExist(userAccount.getUserName());
        if(userNameIsExist){
            return "A user with the same user name already exists.";
        }
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userAccountDao.editUserAccount(userAccount);
        return "A new user edited";
    }
}
