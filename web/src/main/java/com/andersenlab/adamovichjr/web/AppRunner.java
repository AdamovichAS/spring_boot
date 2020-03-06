package com.andersenlab.adamovichjr.web;

import com.andersenlab.adamovichjr.dao.config.DaoConfig;
import com.andersenlab.adamovichjr.service.configuration.ServiceConfig;
import com.andersenlab.adamovichjr.web.config.RootConfig;
import com.andersenlab.adamovichjr.web.config.WebConfig;
import com.andersenlab.adamovichjr.web.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
