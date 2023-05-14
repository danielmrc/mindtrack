package com.mindtrack.mindtrack.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class ConfigurationDatasource {
    /*    
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
        .username("root")
        .password("12345")
        .url("jdbc:mysql://localhost:3306/Teste")
        .driverClassName("com.mysql.jdbc.Driver").build();
    } */
}