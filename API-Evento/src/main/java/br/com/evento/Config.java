package br.com.evento;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class Config {
	
	/*
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUsername("root");
		source.setPassword("q1w2e3r4");
		source.setUrl("jdbc:mysql://localhost:3306/evento");
		return source;
	}
	
	@Bean
	public JpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
	*/
	
	

}
