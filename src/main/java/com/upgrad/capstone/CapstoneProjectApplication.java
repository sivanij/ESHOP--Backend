package com.upgrad.capstone;

import com.upgrad.capstone.dao.eshopUserDAO;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.modelmapper.ModelMapper;
@SpringBootApplication
public class CapstoneProjectApplication {
	@Autowired
	private static ApplicationContext context;

//private ApplicationContext context;
public static void main(String[] args) {
	SpringApplication.run(CapstoneProjectApplication.class, args);
	System.out.println("program check");
}



//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}


}