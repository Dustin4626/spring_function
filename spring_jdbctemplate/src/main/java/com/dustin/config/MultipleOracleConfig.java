package com.dustin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class MultipleOracleConfig {

	// step 1
	@Primary
	@Bean(name = "oracleProperties")
	@ConfigurationProperties("spring.datasource.oracle")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	// step 2
	@Bean(name = "oracleDataSource")
	public DataSource dataSource(@Qualifier("oracleProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	// step 3
	@Bean("oracleJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("oracleDataSource") DataSource ccbsDataSource) {
		return new JdbcTemplate(ccbsDataSource);
	}

	// step 4
	@Bean("oracleTx")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("oracleDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
