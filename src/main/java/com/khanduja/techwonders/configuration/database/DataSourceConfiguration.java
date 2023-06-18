package com.khanduja.techwonders.configuration.database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/all-tech-wonders");
        dataSourceBuilder.username("tech_user");
        dataSourceBuilder.password("password");
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        return dataSourceBuilder.build();
    }
}
