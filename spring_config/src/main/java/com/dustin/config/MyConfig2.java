package com.dustin.config;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class MyConfig2 {

	public static void main(String[] args) throws Exception {
		Resource resource = new FileUrlResource("mailConfig.properties");
		EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
		Properties props = PropertiesLoaderUtils.loadProperties(encodedResource);
		String property = props.getProperty("company");
		System.out.println(property);
	}
}
