package com.taskOne.homeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.taskOne.homeTask")
@EnableJpaRepositories("com.taskOne.homeTask.repository")
@SpringBootApplication
public class HomeTaskApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HomeTaskApplicationRunner.class, args);
	}

}

