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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "com.cet.ibscloud.ibsdao.business.mapper", sqlSessionTemplateRef = "businessSqlSessionTemplate")
public class BusinessMybatisConfig {
	
	@Bean(name = "businessDataSource")
	@Qualifier("businessDataSource")
	@Primary // 配置该数据源为主数据源
	@ConfigurationProperties(prefix = "spring.datasource.business")
	public DataSource businessDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	/**
     * 创建工厂
     *@param dataSource
     *@throws Exception
     *@return SqlSessionFactory
     */
    @Bean(name = "businessSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("businessDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/business/*.xml"));
        return bean.getObject();
    }
    
    /**
     * 创建事务
     *@param dataSource
     *@return DataSourceTransactionManager
     */
    @Bean(name = "businessTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("businessDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    /**
     * 创建模板
     *@param sqlSessionFactory  
     *@return SqlSessionTemplate
     */
    @Bean(name = "businessSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("businessSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
