package com.dustin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SingleDataSourceConfig {
	
//	@Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@172.20.88.88:1521:UECPOS");
//        dataSource.setUsername("IEINV");
//        dataSource.setPassword("IEINV");
//        return dataSource;
//    }
	
}
