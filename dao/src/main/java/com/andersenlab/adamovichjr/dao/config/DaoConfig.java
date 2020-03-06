package com.andersenlab.adamovichjr.dao.config;

import com.andersenlab.adamovichjr.dao.repository.UserAccountRepository;
import com.andersenlab.adamovichjr.dao.IUserAccountDao;
import com.andersenlab.adamovichjr.dao.impl.UserAccountDao;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.andersenlab.adamovichjr.dao.repository")
@EntityScan("com.andersenlab.adamovichjr.dao.entity")
public class DaoConfig {


    private final UserAccountRepository userAccountRepository;

    public DaoConfig(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Bean
    public IUserAccountDao userAccountDao(){
        return new UserAccountDao(userAccountRepository);
    }
}
