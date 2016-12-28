package com.yzhang.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.*"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.*"})
public class AppConfig {
}
