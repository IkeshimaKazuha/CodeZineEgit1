package G_T.OfficeSystem.config;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
/* 修正前
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView; */
//修正後(Hibernateの設定をロードするための修正)
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
@EnableTransactionManagement
@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties") })
@Configuration
@ComponentScan("G_T.OfficeSystem.*")
public class ApplicationContextConfig {
 @Autowired
 private Environment env;
 @Bean(name = "viewResolver")
 public ViewResolver getViewResolver() {
  UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
  viewResolver.setViewClass(TilesView.class);
  return viewResolver;
 }
 @Bean(name = "tilesConfigurer")
 public TilesConfigurer getTilesConfigurer() {
  TilesConfigurer tilesConfigurer = new TilesConfigurer();
  // TilesView 3
  tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
  return tilesConfigurer;
 }
 @Bean(name = "dataSource")
 public DataSource getDataSource() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
  dataSource.setUrl(env.getProperty("ds.url"));
  dataSource.setUsername(env.getProperty("ds.username"));
  dataSource.setPassword(env.getProperty("ds.password"));
  return dataSource;
 }
 @Bean(name = "transactionManager")
 public DataSourceTransactionManager getTransactionManager() {
  DataSourceTransactionManager txManager = new DataSourceTransactionManager();
  DataSource dataSource = this.getDataSource();
  txManager.setDataSource(dataSource);
  return txManager;
 }
 //HibernateのSessionFactoryを設定する
 @Bean(name = "sessionFactory")
 public SessionFactory getSessionFactory() {
  try {
   // Create the SessionFactory from hibernate.cfg.xml
   org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
   configuration.configure("hibernate.cfg.xml");
   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
     .applySettings(configuration.getProperties()).build();
   SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
   return sessionFactory;
  } catch (Exception ex) {
   ex.printStackTrace();
   return null;
  }
 }
}