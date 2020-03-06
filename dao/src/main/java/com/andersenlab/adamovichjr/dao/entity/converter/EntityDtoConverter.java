package com.andersenlab.adamovichjr.dao.entity.converter;


import com.andersenlab.adamovichjr.dao.entity.UserAccountEntity;
import com.andersenlab.adamovichjr.model.AuthUserDto;
import com.andersenlab.adamovichjr.model.UserAccountDto;

public final class EntityDtoConverter {
    private EntityDtoConverter() {
    }

    public static AuthUserDto getAuthUserDto(UserAccountEntity entity){
        final AuthUserDto dto = new AuthUserDto(entity.getUserName(),entity.getPassword());
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static UserAccountDto getUserAccountDto(UserAccountEntity entity){
        UserAccountDto dto = new UserAccountDto();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static UserAccountEntity getUserAccountEntity(UserAccountDto dto){
        final UserAccountEntity entity = new UserAccountEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
