package com.github.adamovichas.hes.dao.impl;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.dao.entity.AuthUserEntity;
import com.github.adamovichas.hes.dao.entity.converter.EntityDtoConverter;
import com.github.adamovichas.hes.dao.repository.AuthUserRepository;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountView;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

public class UserAccountDao implements IUserAccountDao {

    private final AuthUserRepository authUserRepository;

    public UserAccountDao(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public AuthUserDto getByLogin(String userMame) {
        final AuthUserEntity authUserEntity = authUserRepository.findByUserName(userMame);
        if (authUserEntity == null){
            return null;
        }
        return EntityDtoConverter.getDto(authUserEntity);
    }

    @Override
    public List<UserAccountView> getUserAccountViewsOnPag(int currentPage, int pageSize) {
        final List<AuthUserEntity> authUserEntities = authUserRepository.findAll(PageRequest.of(currentPage - 1, pageSize)).toList();
        List<UserAccountView>views = new ArrayList<>();
        for (AuthUserEntity entity : authUserEntities) {
            views.add(EntityDtoConverter.getView(entity));
        }
        return views;
    }

    @Override
    public Long getCountUserAccounts() {
        return null;
    }
}
