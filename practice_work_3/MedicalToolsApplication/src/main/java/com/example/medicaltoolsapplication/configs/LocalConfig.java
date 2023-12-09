package com.example.medicaltoolsapplication.configs;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.MapInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
public class LocalConfig {
    @Bean
    public InfoContributor getInfoContributor(){
        Map<String, Object> details = new HashMap<>();
        details.put("nameApp", "Medical devices");
        details.put("description", "application for medical devices");
        details.put("developer", "Evgenii and Matvey");
        details.put("email", "LETI@gmail.com");
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("info", details);
        return new MapInfoContributor(wrapper);
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("ru", "RU"));
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
