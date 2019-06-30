package com.syjpro.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/*
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

*/
@Configuration // 定义配置信息类
public class DataSourceConfig {
    /** 定义创建数据源方法 */
    @Bean(name="dataSource") // 定义Bean
    @Primary // 主要的候选者
    @ConfigurationProperties(prefix="spring.datasource.c3p0") // 配置属性
    public DataSource getDataSource(){
        return DataSourceBuilder.create() // 创建数据源构建对象
                .type(ComboPooledDataSource.class) // 设置数据源类型
                .build(); // 构建数据源对象
    }
}
