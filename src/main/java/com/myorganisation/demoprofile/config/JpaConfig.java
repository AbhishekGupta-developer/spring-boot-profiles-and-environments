package com.myorganisation.demoprofile.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Profile("dev")
    @Bean
    public DataSource mysqlDataSource() {

        System.out.println("Connecting to MySQL DB - dev env");

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/demoprofile?createDatabaseIfNotExist=true");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");

        return dataSourceBuilder.build();
    }

    @Profile("prod")
    @Bean
    public DataSource myPostgresqlDataSource() {

        System.out.println("Connecting to PostgreSQL DB - prod env");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/demoprofile");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("root");

        return dataSourceBuilder.build();
    }

}
