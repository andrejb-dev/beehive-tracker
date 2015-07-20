/*
 * Copyright 2014 Andrej Badinka
 */
package sk.abadinka.beehive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.abadinka.beehive.services.YardService;

/**
 *
 * @author abadinka
 */
@Configuration
public class AppContext {
    
    @Bean
    public YardService yardService(){
        return new YardService();
    }
}
