package com.dustin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(
		value = {"file:E:\\workspace\\Tice_demo\\mailConfig.properties"},
//      value = {"classpath:mailConfig.properties"},
      ignoreResourceNotFound = false,
      encoding = "UTF-8"
)
@Configuration
public class MyConfig {

	@Value("${company}")
	public String company;
	
	@Value("${mailto}")
	public String mailto;
	
	@Autowired
	protected Environment env;

	public String getProperty(String key) {
		return env.getProperty(key);
	}
}
