package com.github.adamovichas.hes.service.configuration;

import com.github.adamovichas.hes.dao.config.DaoConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private final DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }
}
