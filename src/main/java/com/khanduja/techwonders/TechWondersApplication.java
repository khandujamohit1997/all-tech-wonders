package com.khanduja.techwonders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class TechWondersApplication implements CommandLineRunner {

    //http://localhost:8082/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(TechWondersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
