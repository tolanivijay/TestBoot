package com.vijay.starter;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories(basePackageClasses=EmpRepository.class)
@EnableMongoRepositories(basePackages="com.vijay")
@SpringBootApplication(scanBasePackages="com.vijay")
public class Starter {

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);

	}
	
	
	@Bean
	public String name2() {
		return "Deep1";
	}
	
	
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
