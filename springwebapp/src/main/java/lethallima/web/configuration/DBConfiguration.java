package lethallima.web.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by LethalLima on 7/20/16.
 */
@Configuration
@EnableTransactionManagement
public class DBConfiguration {
    @Autowired
    private PropertiesPlaceholder prop;

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("lethallima.web.entities")
                .addProperties(getHibernateProperties());
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties hibernateProps = new Properties();
        hibernateProps.put("hibernate.show_sql", prop.isHibernateShowSql());
        hibernateProps.put("hibernate.format_sql", prop.isHibernateFormatSql());
        hibernateProps.put("hibernate.dialect", prop.getHibernateDialect());
        return hibernateProps;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(prop.getDriver());
        driverManagerDataSource.setUrl(prop.getUrl());
        driverManagerDataSource.setUsername(prop.getUsername());
        driverManagerDataSource.setPassword(prop.getPassword());
        return driverManagerDataSource;
    }

    //Create a transaction manager
    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
