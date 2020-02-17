package com.github.adamovichas.hes.service.configuration;

import com.github.adamovichas.hes.dao.config.DaoConfig;
import com.github.adamovichas.hes.service.IUserAccountService;
import com.github.adamovichas.hes.service.impl.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {

    private final DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }


    @Bean
    public IUserAccountService userAccountService(){
        return new UserAccountService(daoConfig.userAccountDao(),passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
