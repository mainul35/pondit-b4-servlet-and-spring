package com.mainul35.bsuserinfo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableR2dbcRepositories(basePackages = "com.mainul35.bsuserinfo.repositories")
//public class DbConfig  extends AbstractR2dbcConfiguration {
//
//    @Value("${datasource.host}")
//    private String host;
//    @Value("${datasource.port}")
//    private int port;
//    @Value("${datasource.database}")
//    private String database;
//    @Value("${datasource.username}")
//    private String username;
//    @Value("${datasource.password}")
//    private String password;
//    @Bean
//    @Override
//    public ConnectionFactory connectionFactory() {
//
//        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration
//                .builder()
//                .host(host)
//                .database(database)
//                .username(username)
//                .password(password)
//                .port(port)
//                .build());
//    }
//
//    // DatabaseClient will be required for executing queries
//    @Bean
//    public DatabaseClient r2dbcDatabaseClient() {
//        return DatabaseClient.create(connectionFactory());
//    }
//}