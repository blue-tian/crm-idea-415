package com.bing.guo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许的头
        corsConfiguration.addAllowedHeader("*");
        //允许的域
        corsConfiguration.addAllowedOrigin("*");
        //允许的方法
        corsConfiguration.addAllowedMethod("*");
        //是否允许携带cookie
        corsConfiguration.setAllowCredentials(false);
        //针对哪些路径
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);
        return corsFilter;
    }
}
