package com.dustin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class MultiplemysqlConfig {

	// step 1
	@Bean(name = "mysqlProperties")
	@ConfigurationProperties("spring.datasource.mysql")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	// step 2
	@Bean(name = "mysqlDataSource")
	public DataSource dataSource(@Qualifier("mysqlProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	// step 3
	@Bean("mysqlJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("mysqlDataSource") DataSource ccbsDataSource) {
		return new JdbcTemplate(ccbsDataSource);
	}

	// step 4
	@Bean("mysqlTx")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
