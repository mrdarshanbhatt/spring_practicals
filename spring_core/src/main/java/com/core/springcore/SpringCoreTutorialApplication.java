package com.core.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreTutorialApplication {
	
	// In spring Support Auto Component Scanning 
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreTutorialApplication.class,
				args);

		// By Default Spring Create SingleTon Object if Change then Use @Scope name Prototype
		User user = applicationContext.getBean(User.class); 
		
		User user2 = applicationContext.getBean(User.class);
		
		// Here Create object 2 time but First Object is singleTon so create only Once

	}

}
