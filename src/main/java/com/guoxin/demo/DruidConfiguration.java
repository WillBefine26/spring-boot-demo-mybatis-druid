package com.guoxin.demo;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created by liangchong998 on 2016/8/18.
 */
@Configuration
public class DruidConfiguration {
    @Primary //默认数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.druid")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
}
