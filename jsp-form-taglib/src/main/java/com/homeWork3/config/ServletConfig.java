package com.homeWork3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = {"com.homeWork3.controllers"})
public class ServletConfig implements WebMvcConfigurer {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for -

        // IMAGES
        registry.addResourceHandler("/images/**") // Relative paths
                .addResourceLocations("/WEB-INF/resources/images/") // Actual resource locations
                .setCachePeriod(999999999); // Cache period

        // CSS
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/resources/css/")
                .setCachePeriod(999999999);

        // JAVASCRIPT
        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/resources/js/")
                .setCachePeriod(999999999);

        // Other template resource vendor files
        registry
                .addResourceHandler("/vendor/**")
                .addResourceLocations("/WEB-INF/resources/vendor/")
                .setCachePeriod(999999999);
    }
}
