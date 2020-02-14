package com.github.adamovichas.hes.dao.entity.converter;

import com.github.adamovichas.hes.dao.entity.AuthUserEntity;
import com.github.adamovichas.hes.model.AuthUserDto;
import com.github.adamovichas.hes.model.UserAccountView;

public final class EntityDtoConverter {
    private EntityDtoConverter() {
    }

    public static AuthUserDto getDto(AuthUserEntity entity){
        final AuthUserDto dto = new AuthUserDto(entity.getUserName(),entity.getPassword());
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static UserAccountView getView(AuthUserEntity entity){
        UserAccountView view = new UserAccountView();
        view.setUserName(entity.getUserName());
        view.setFirstName(entity.getUserInfo().getFirstName());
        view.setLastName(entity.getUserInfo().getLastName());
        view.setRole(entity.getRole());
        view.setStatus(entity.getStatus());
        view.setCreatedAt(entity.getUserInfo().getCreatedAt());
        return view;
    }
}
