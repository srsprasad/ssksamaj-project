package org.ssksamaj.app.persist;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class PersistenceConfig {

	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.defaultSchema}")
	private String defaultSchema;
	
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hConfig = new HikariConfig();
		hConfig.setJdbcUrl(jdbcUrl);
		hConfig.setUsername(username);
		hConfig.setPassword(password);
		hConfig.setDriverClassName(driverClassName);
		hConfig.setSchema(defaultSchema);
		HikariDataSource hDataSource = new HikariDataSource(hConfig);
		return hDataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
		jpaAdapter.setGenerateDdl(false);
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(jpaAdapter);
		factoryBean.setPackagesToScan("org.ssksamaj.app.persist");
		factoryBean.setDataSource(dataSource());
		factoryBean.afterPropertiesSet();
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
	
}
