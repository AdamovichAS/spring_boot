package com.github.adamovichas.hes.service.configuration;

import com.github.adamovichas.hes.dao.config.DaoConfig;
import com.github.adamovichas.hes.service.IUserAccountService;
import com.github.adamovichas.hes.service.impl.UserAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private final DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public IUserAccountService userAccountService(){
        return new UserAccountService(daoConfig.userAccountDao());
    }
}
