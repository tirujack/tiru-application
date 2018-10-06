package com.tiru.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by oustlabs on 05/10/18.
 */
@SpringBootApplication
@ComponentScan({"com.tiru"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.tiru.rest.dao")
@EnableTransactionManagement
@EntityScan(basePackages="com.tiru.rest.bean.model")
public class TodoApplication {
    public static void main(String[] args) {
       SpringApplication.run(TodoApplication.class, args);
    }
}



