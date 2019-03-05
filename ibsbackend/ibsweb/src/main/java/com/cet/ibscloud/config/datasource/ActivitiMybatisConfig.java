package com.cet.ibscloud.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "com.cet.ibscloud.ibsdao.activiti.mapper", sqlSessionTemplateRef = "activitiSqlSessionTemplate")
public class ActivitiMybatisConfig {
	
	@Bean(name = "activitiDataSource")
	@Qualifier("activitiDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.activiti")
	public DataSource activitiDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	/**
     * 创建工厂
     *@param dataSource
     *@throws Exception
     *@return SqlSessionFactory
     */
    @Bean(name = "activitiSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("activitiDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/activiti/*.xml"));
        return bean.getObject();
    }
    
    /**
     * 创建事务
     *@param dataSource
     *@return DataSourceTransactionManager
     */
    @Bean(name = "activitiTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("activitiDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    /**
     * 创建模板
     *@param sqlSessionFactory  
     *@return SqlSessionTemplate
     */
    @Bean(name = "activitiSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("activitiSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
