package com.dustin.springbootdemo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SpringboottestApplicationTests {

	@Autowired
	@Qualifier("oracleJdbcTemplate")
	JdbcTemplate oracleJdbcTemplate;
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	JdbcTemplate mysqlJdbcTemplate;
	
	@Test
	void contextLoads() {
		
	}

//	@Test
	public void testOracle() {
		System.out.println("====>oracleJdbcTemplate");
		List<Map<String, Object>> queryForList = oracleJdbcTemplate.queryForList("select * from CODE_LIST");
		queryForList.forEach(System.out::println);
	}
	
//	@Test
	public void testMysql() {
		System.out.println("====>mysqlJdbcTemplate");
		List<Map<String, Object>> queryForList = mysqlJdbcTemplate.queryForList("select * from t_type");
		queryForList.forEach(System.out::println);
	}
	
	@Test
	@Transactional("chainedTransactionManager")
	public void chainTest() {
		System.out.println("====>chain");
		mysqlJdbcTemplate.execute("INSERT INTO t_type (name) VALUES ('8')");
		oracleJdbcTemplate.execute("INSERT INTO CODE_LIST (CID,CODE_ID) VALUES ('00001','UEC01')");
		
		System.out.println("====>done<====");
		List<Map<String, Object>> queryForList = oracleJdbcTemplate.queryForList("select * from CODE_LIST");
		queryForList.forEach(System.out::println);
		
		List<Map<String, Object>> queryForList2 = mysqlJdbcTemplate.queryForList("select * from t_type");
		queryForList2.forEach(System.out::println);
		
		int i = 1/0;
	}
}
