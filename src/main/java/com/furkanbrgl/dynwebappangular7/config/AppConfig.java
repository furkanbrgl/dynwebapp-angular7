package com.furkanbrgl.dynwebappangular7.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfig {

    private List<String> corsAllowOrigins = new ArrayList<String>();


    public List<String> getCorsAllowOrigins() {
        return corsAllowOrigins;
    }

    public void setCorsAllowOrigins(List<String> corsAllowOrigins) {
        this.corsAllowOrigins = corsAllowOrigins;
    }
}
