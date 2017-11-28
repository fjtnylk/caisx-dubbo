package com.muy.dubbo.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.muy.system.datasource.DynamicDataSource;
import com.muy.system.datasource.DynamicDataSourceHolder;
import com.muy.system.datasource.annotation.DbMsEnum;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@AutoConfigureAfter({JdbcProperties.class})
@EnableTransactionManagement
public class DatasourceConfig {
  @Resource
  private JdbcProperties jdbcProperties;

  /**
   * 初始化主数据源.
   *
   * @return 主数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "masterDs", initMethod = "init", destroyMethod = "close")
  @Primary
  public DruidDataSource masterDs() throws SQLException {
    DruidDataSource masterDs = new DruidDataSource();
    masterDs.setUrl(jdbcProperties.getWriteUrl());
    masterDs.setUsername(jdbcProperties.getWriteUsername());
    masterDs.setPassword(jdbcProperties.getWritePassword());

    masterDs.setFilters(jdbcProperties.getFilters());
    masterDs.setMaxActive(jdbcProperties.getMaxActive());
    masterDs.setInitialSize(jdbcProperties.getInitialSize());
    masterDs.setMaxWait(jdbcProperties.getMaxWait());
    masterDs.setMinIdle(jdbcProperties.getMinIdle());

    masterDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    masterDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    masterDs.setValidationQuery(jdbcProperties.getValidationQuery());
    masterDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    masterDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    masterDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    masterDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    masterDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return masterDs;
  }

  /**
   * 初始化从数据源.
   *
   * @return 从数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "slaveDs", initMethod = "init", destroyMethod = "close")
  public DruidDataSource slaveDs() throws SQLException {
    DruidDataSource slaveDs = new DruidDataSource();
    slaveDs.setUrl(jdbcProperties.getReadUrl());
    slaveDs.setUsername(jdbcProperties.getReadUsername());
    slaveDs.setPassword(jdbcProperties.getReadPassword());

    slaveDs.setFilters(jdbcProperties.getFilters());
    slaveDs.setMaxActive(jdbcProperties.getMaxActive());
    slaveDs.setInitialSize(jdbcProperties.getInitialSize());
    slaveDs.setMaxWait(jdbcProperties.getMaxWait());
    slaveDs.setMinIdle(jdbcProperties.getMinIdle());

    slaveDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    slaveDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    slaveDs.setValidationQuery(jdbcProperties.getValidationQuery());
    slaveDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    slaveDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    slaveDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    slaveDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    slaveDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return slaveDs;
  }

  /**
   * 初始化事务数据源.
   *
   * @return 事务数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "dataSource")
  public DynamicDataSource dataSource() throws SQLException {
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    dynamicDataSource.setDefaultTargetDataSourceName(DbMsEnum.MASTER.get());

    Map<Object, Object> targets = new HashMap<>();
    targets.put(DbMsEnum.MASTER.get(), masterDs());
    targets.put(DbMsEnum.SLAVE.get(), slaveDs());
    dynamicDataSource.setTargetDataSources(targets);
    DynamicDataSourceHolder.putDataSource(DbMsEnum.MASTER.get());
    return dynamicDataSource;
  }
}
