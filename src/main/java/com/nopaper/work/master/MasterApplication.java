package com.nopaper.work.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/*
 * @SpringBootApplication(exclude = { JpaRepositoriesAutoConfiguration.class,
 * R2dbcDataAutoConfiguration.class, R2dbcRepositoriesAutoConfiguration.class })
 * 
 * @EnableDiscoveryClient
 * 
 * @EnableCaching
 * 
 * @EnableR2dbcRepositories(basePackages =
 * "com.nopaper.work.master.reactive.repositories")
 * 
 * @EnableJpaRepositories(basePackages = "com.nopaper.work.master.repositories")
 * public class MasterApplication {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(MasterApplication.class, args); }
 * 
 * }
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableR2dbcRepositories(basePackages = "com.nopaper.work.master.reactive.repositories")
public class MasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class, args);
    }

}