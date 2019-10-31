package com.rls.springbootvue.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Setter
@Getter
@MapperScan(basePackages = {"com.rls.springbootvue.dao*"},
        sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfiguration {
    public final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Bean(name = "clusterDataSource")
    @Primary
    public DataSource clusterDataSource() {
        logger.info("初始化数据库连接池:" + url);
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
//        datasource.setPassword(Encrypter.decrypt(password));
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        logger.info("初始化数据库连接池完成");
        return datasource;
    }
    @Bean(name = "clusterTransactionManager")
    @Primary
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfiguration.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
