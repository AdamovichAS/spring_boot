package com.andersenlab.adamovichjr.web.config;

import com.andersenlab.adamovichjr.service.configuration.ServiceConfig;
import com.andersenlab.adamovichjr.web.controller.UserAccountController;
import com.andersenlab.adamovichjr.web.controller.authentification.LoginController;
import com.andersenlab.adamovichjr.web.controller.authentification.RegistrationController;
import com.andersenlab.adamovichjr.web.controller.authentification.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.util.Locale;


@Configuration
@EnableWebMvc
public class WebConfig {

    private final ServiceConfig serviceConfig;

    public WebConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/view/tiles.xml");
        return tilesConfigurer;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasenames("classpath:/interface","classpath:/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("en_US"));
        resolver.setCookieName("LocaleCookie");
        resolver.setCookieMaxAge(3600);
        return resolver;
    }


    @Bean
    public MyUserDetailService userDetailService(){
        return new MyUserDetailService(serviceConfig.userAccountService());
    }

    @Bean
    public UserAccountController userAccountController(){
        return new UserAccountController(serviceConfig.userAccountService());
    }

    @Bean
    public LoginController loginController(){
        return new LoginController();
    }

    @Bean
    public RegistrationController registrationController(){
        return new RegistrationController(serviceConfig.userAccountService());
    }
}
