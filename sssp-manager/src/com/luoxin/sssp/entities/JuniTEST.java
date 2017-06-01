package com.luoxin.sssp.entities;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JuniTEST {
	private ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	}

	@Test
	public void test() throws SQLException {
		DataSource ds = ctx.getBean(DataSource.class);
		System.out.println(ds.getConnection());
	}
}
