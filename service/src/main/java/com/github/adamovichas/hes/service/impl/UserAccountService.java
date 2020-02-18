package com.github.adamovichas.hes.service.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.Page;
import com.github.adamovichas.hes.model.UserAccountDto;
import com.github.adamovichas.hes.service.IUserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.nonNull;

public class UserAccountService implements IUserAccountService {

    private static final int PAGE_SIZE = 5;
    private final IUserAccountDao userAccountDao;
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserAccountService(IUserAccountDao userAccountDao, PasswordEncoder bCryptPasswordEncoder) {
        this.userAccountDao = userAccountDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    @Transactional
    public AuthUserDto findByUserName(String userName) {
        return userAccountDao.findByUserName(userName);
    }

    @Override
    @Transactional
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
    @Transactional
    public UserAccountDto getUserAccountViewById(Long id) {
        return userAccountDao.getUserAccountDtoById(id);
    }

    @Override
    @Transactional
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
    @Transactional
    public String editUserAccount(UserAccountDto editedUserAccount) {
        final UserAccountDto userAccountFromDB = userAccountDao.getUserAccountDtoById(editedUserAccount.getId());
        if(!userAccountFromDB.getUserName().equals(editedUserAccount.getUserName())){
            final boolean userNameIsExist = userAccountDao.userNameIsExist(editedUserAccount.getUserName());
            if(userNameIsExist){
                return "A user with the same user name already exists.";
            }
        }
        if(nonNull(editedUserAccount.getPassword())) {
            editedUserAccount.setPassword(bCryptPasswordEncoder.encode(editedUserAccount.getPassword()));
        }
        userAccountDao.editUserAccount(editedUserAccount);
        return "A new user edited";
    }
}
