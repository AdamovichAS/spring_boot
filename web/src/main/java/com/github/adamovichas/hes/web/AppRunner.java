package com.github.adamovichas.hes.web;

import com.github.adamovichas.hes.dao.config.DaoConfig;
import com.github.adamovichas.hes.service.configuration.ServiceConfig;
import com.github.adamovichas.hes.web.config.RootConfig;
import com.github.adamovichas.hes.web.config.WebConfig;
import com.github.adamovichas.hes.web.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@Import({DaoConfig.class, ServiceConfig.class, WebConfig.class, WebSecurityConfig.class, RootConfig.class})
public class AppRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }
}
