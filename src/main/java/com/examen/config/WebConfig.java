package com.examen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new SesionInterceptor())
                .addPathPatterns("/**") 
                .excludePathPatterns("/", "/login", "/logout", "/css/**", "/js/**", "/img/**");
    }
}
