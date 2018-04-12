package com.ding.readWriteSparation.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;
    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(roundRobinDataSouceProxy());
    }

    public AbstractRoutingDataSource roundRobinDataSouceProxy(){
        log.info("init sqlSessionFactory");

        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();

        Map<Object,Object> targetDataResources = new ClassLoaderRepository.SoftHashMap();
        targetDataResources.put(DbContextHolder.DbType.MASTER,masterDataSource);
        targetDataResources.put(DbContextHolder.DbType.SLAVE,slaveDataSource);

        proxy.setDefaultTargetDataSource(masterDataSource);//默认源
        proxy.setTargetDataSources(targetDataResources);

        return proxy;
    }
}
