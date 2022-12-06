package com.bytecode.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Connection;
import com.bytecode.core.services.PostService;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;
	
	@Autowired
	@Qualifier("com.bytecode.core.components.PostComponent")
	private PostComponent postComponent;
	
	@Autowired
	@Qualifier("decorated")
	private PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Log log = LogFactory.getLog(getClass());
		
		postService.validation(postComponent.getPost())
		.forEach((posts)->{
			log.info(posts.getTitle());
		});
		
	}

}
