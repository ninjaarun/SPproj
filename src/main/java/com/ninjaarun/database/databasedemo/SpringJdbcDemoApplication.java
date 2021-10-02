package com.ninjaarun.database.databasedemo;

import com.ninjaarun.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}", dao.findAll());
		logger.info("\n");

		logger.info("{}", dao.findSpecificData("Bangalore"));
		logger.info("\n\n");

		logger.info("User id 10001 -> {}", dao.findById(10001));

		logger.info("No of rows deleted - {} ", dao.deleteById(10002));
		logger.info("\n\n");
		logger.info("{}", dao.findAll());
		logger.info("\n\n");

		logger.info("we are inserting data - {}", dao.insertData(1234, "PAWAN", "Guj"));

		logger.info("\n\n");
		logger.info("{}", dao.findAll());

	}
}
