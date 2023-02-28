package com.example.RentCars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RentCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarsApplication.class, args);
	}

}
