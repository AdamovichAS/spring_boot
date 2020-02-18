package com.github.adamovichas.hes.dao.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;

import com.github.adamovichas.hes.dao.entity.UserAccountEntity;
import com.github.adamovichas.hes.dao.entity.converter.EntityDtoConverter;
import com.github.adamovichas.hes.dao.repository.UserAccountRepository;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class UserAccountDao implements IUserAccountDao {

    private final UserAccountRepository userAccountRepository;

    public UserAccountDao(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthUserDto findByUserName(String userMame) {
        final UserAccountEntity userAccount = userAccountRepository.findByUserName(userMame);
//        if (authUserEntity == null){
//            return null;
//        }
//        return EntityDtoConverter.getAuthUserDto(authUserEntity);
        if(nonNull(userAccount) && userAccount.getUserName().equals(userMame)){
            return EntityDtoConverter.getAuthUserDto(userAccount);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<UserAccountDto> getUserAccountViewsOnPag(int currentPage, int pageSize) {
        final List<UserAccountEntity> authUserEntities = userAccountRepository.findAll(PageRequest.of(currentPage - 1, pageSize)).toList();
        List<UserAccountDto>dtos = new ArrayList<>();
        for (UserAccountEntity entity : authUserEntities) {
            dtos.add(EntityDtoConverter.getUserAccountDto(entity));
        }
        return dtos;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Long getCountUserAccounts() {
        return userAccountRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UserAccountDto getUserAccountDtoById(Long id) {
        final UserAccountEntity entity = userAccountRepository.getOne(id);
        return EntityDtoConverter.getUserAccountDto(entity);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean userNameIsExist(String userName) {
        final UserAccountEntity userAccount = userAccountRepository.findByUserName(userName);
        if(nonNull(userAccount)){
            return userAccount.getUserName().equals(userName);
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addUserAccount(UserAccountDto userAccount) {
        final UserAccountEntity userAccountEntity = EntityDtoConverter.getUserAccountEntity(userAccount);
        userAccountRepository.save(userAccountEntity);
        userAccount.setId(userAccountEntity.getId());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void editUserAccount(UserAccountDto userAccount) {
        final UserAccountEntity entity = userAccountRepository.getOne(userAccount.getId());
        entity.setUserName(userAccount.getUserName());
        if(nonNull(userAccount.getPassword())) {
            entity.setPassword(userAccount.getPassword());
        }
        entity.setFirstName(userAccount.getFirstName());
        entity.setLastName(userAccount.getLastName());
        entity.setRole(userAccount.getRole());
        entity.setStatus(userAccount.getStatus());
        userAccountRepository.flush();
    }
}
