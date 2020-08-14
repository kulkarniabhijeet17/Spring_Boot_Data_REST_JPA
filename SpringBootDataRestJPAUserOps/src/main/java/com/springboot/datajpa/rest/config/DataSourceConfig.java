package com.springboot.datajpa.rest.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootConfiguration
@ConfigurationProperties("oracle")
public class DataSourceConfig {
	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String url;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Bean
	DataSource dataSource() throws SQLException {
		Properties props = new Properties();
		props.setProperty("MinLimit", "2");
		props.setProperty("MaxLimit", "10");

		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setConnectionCachingEnabled(true);
		dataSource.setConnectionCacheProperties(props);
		dataSource.setConnectionCacheName("ImplicitCache");

		return dataSource;
	}
}