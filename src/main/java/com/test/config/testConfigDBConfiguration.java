package com.test.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.test.dao" }, entityManagerFactoryRef = "testconfigDSEmFactory", transactionManagerRef = "testconfigDSTransactionManager")
public class testConfigDBConfiguration {

	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties testconfigDSProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource testconfigDS(@Qualifier("testconfigDSProperties") DataSourceProperties testconfigDSProperties) {
		return testconfigDSProperties.initializeDataSourceBuilder().build();

	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean testconfigDSEmFactory(
			@Qualifier("testconfigDS") DataSource testconfigDS, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(testconfigDS).packages("com.test.model").build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager testconfigDSTransactionManager(EntityManagerFactory testconfigDSEmFactory) {
		return new JpaTransactionManager(testconfigDSEmFactory);
	}
}
