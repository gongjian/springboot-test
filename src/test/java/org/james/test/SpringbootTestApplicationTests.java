package org.james.test;

import org.james.test.model.PropertiesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestApplicationTests {
	
	@Autowired  
    private Environment env; 
	
	@Autowired
	private ApplicationContext applicationContext;

	@Value("${test.content}")
	private String testContent;
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@Test
	public void contextLoads() {
		System.out.println(env.getProperty("test.content"));
		System.out.println(applicationContext.getEnvironment().getProperty("test.content"));
		System.out.println(propertiesConfig.getContent());
		System.out.println(testContent);
		
	}

}
