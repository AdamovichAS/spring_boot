package com.github.adamovichas.hes.service;

import com.github.adamovichas.hes.model.AuthUserDto;

public interface IUserAccountService {
    AuthUserDto loginAuthUser(AuthUserDto user);
}
