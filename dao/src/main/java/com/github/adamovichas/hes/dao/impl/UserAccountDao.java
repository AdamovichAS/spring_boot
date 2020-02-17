package com.github.adamovichas.hes.dao.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;

import com.github.adamovichas.hes.dao.entity.UserAccountEntity;
import com.github.adamovichas.hes.dao.entity.converter.EntityDtoConverter;
import com.github.adamovichas.hes.dao.repository.UserAccountRepository;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountDto;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDao implements IUserAccountDao {

    private final UserAccountRepository userAccountRepository;

    public UserAccountDao(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public AuthUserDto getByUserName(String userMame) {
        final UserAccountEntity authUserEntity = userAccountRepository.findByUserName(userMame);
        if (authUserEntity == null){
            return null;
        }
        return EntityDtoConverter.getAuthUserDto(authUserEntity);
    }

    @Override
    public List<UserAccountDto> getUserAccountViewsOnPag(int currentPage, int pageSize) {
        final List<UserAccountEntity> authUserEntities = userAccountRepository.findAll(PageRequest.of(currentPage - 1, pageSize)).toList();
        List<UserAccountDto>dtos = new ArrayList<>();
        for (UserAccountEntity entity : authUserEntities) {
            dtos.add(EntityDtoConverter.getUserAccountDto(entity));
        }
        return dtos;
    }

    @Override
    public Long getCountUserAccounts() {
        return userAccountRepository.count();
    }

    @Override
    public UserAccountDto getUserAccountDtoById(Long id) {
        final UserAccountEntity entity = userAccountRepository.getOne(id);
        return EntityDtoConverter.getUserAccountDto(entity);
    }

    @Override
    public boolean userNameIsExist(String userName) {
        return userAccountRepository.existsByUserName(userName);
    }

    @Override
    public void addUserAccount(UserAccountDto userAccount) {
        final UserAccountEntity userAccountEntity = EntityDtoConverter.getUserAccountEntity(userAccount);
        userAccountRepository.save(userAccountEntity);
        userAccount.setId(userAccountEntity.getId());
    }

    @Override
    public void editUserAccount(UserAccountDto userAccount) {
        final UserAccountEntity entity = userAccountRepository.getOne(userAccount.getId());
        entity.setUserName(userAccount.getUserName());
        entity.setPassword(userAccount.getPassword());
        entity.setFirstName(userAccount.getFirstName());
        entity.setLastName(userAccount.getLastName());
        entity.setRole(userAccount.getRole());
        entity.setStatus(userAccount.getStatus());
        userAccountRepository.flush();
    }
}
