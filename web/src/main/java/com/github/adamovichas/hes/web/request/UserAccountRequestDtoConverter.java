package com.github.adamovichas.hes.web.request;

import com.github.adamovichas.hes.model.UserAccountDto;

public final class UserAccountRequestDtoConverter {
    private UserAccountRequestDtoConverter() {
    }

    public static UserAccountDto getDto(UserAccountRequest request){
        final UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setId(request.getId());
        userAccountDto.setUserName(request.getUserName());
        userAccountDto.setPassword(request.getPassword());
        userAccountDto.setFirstName(request.getFirstName());
        userAccountDto.setLastName(request.getLastName());
        userAccountDto.setStatus(request.getStatus());
        userAccountDto.setRole(request.getRole());
        return userAccountDto;
    }
}
