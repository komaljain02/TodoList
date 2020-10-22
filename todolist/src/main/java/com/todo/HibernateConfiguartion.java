package com.todo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguartion {

	@Value("${db.driver}")
	private String driver;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${entitymanager.packagesToScan}")
	private String packagestoscan;

	@Value("${hibernate.show_sql}")
	private String show_sql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl_auto;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName(driver);
		dmd.setUrl(url);
		dmd.setUsername(username);
		dmd.setPassword(password);
		return dmd;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lcb = new LocalSessionFactoryBean();
		lcb.setDataSource(dataSource());
		lcb.setPackagesToScan(packagestoscan);
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", show_sql);
		prop.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		prop.put("hibernate.dialect", dialect);
		prop.put("entitymanager.packagesToScan", packagestoscan);
		lcb.setHibernateProperties(prop);
		return lcb;
	}

	@Bean
	public HibernateTransactionManager manageTransaction() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm;
	}

}
