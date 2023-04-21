package com.proyecto.salvus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

        viewControllerRegistry
                .addViewController("/")
                .setViewName("index");

        viewControllerRegistry
                .addViewController("/index")
                .setViewName("index");

        viewControllerRegistry
                .addViewController("/login")
                .setViewName("login");

        viewControllerRegistry
                .addViewController("/errores/403")
                .setViewName("/errores/403");

    }

}
