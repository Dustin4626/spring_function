package com.dustin;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.dustin.config.MyConfig;

@SpringBootTest
class SpringFunctionApplicationTests {

	@Autowired
	MyConfig config;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void readProperty() {
		System.out.println(config.company);
	}
	
	@Test
	void readProperty2() throws Exception {
		Resource resource = new FileUrlResource("mailConfig.properties");
		EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
		Properties props = PropertiesLoaderUtils.loadProperties(encodedResource);
		String property = props.getProperty("company");
		System.out.println(property);
	}

	@Test
	void readProperty3() throws Exception {
		//by Environment
		System.out.println(config.getProperty("company"));
	}
}
