package com.github.adamovichas.hes.dao.config;

import com.github.adamovichas.hes.dao.IUserAccountDao;
import com.github.adamovichas.hes.dao.impl.UserAccountDao;
import com.github.adamovichas.hes.dao.repository.AuthUserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.adamovichas.hes.dao.repository")
@EntityScan("com.github.adamovichas.hes.dao.entity")
public class DaoConfig {


    private final AuthUserRepository userAccountRepository;

    public DaoConfig(AuthUserRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Bean
    public IUserAccountDao userAccountDao(){
        return new UserAccountDao(userAccountRepository);
    }
}
