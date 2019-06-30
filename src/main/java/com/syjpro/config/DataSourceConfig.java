package com.syjpro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//配置C3P0连接池
@Configuration
public class DataSourceConfig {
    @ConfigurationProperties(prefix = "spring.datasource.c3p0")//指定配置文件中，对应c3p0的属性值
    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}
