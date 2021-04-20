package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

    @Autowired
    private Environment env;

    @Bean("session-factory")
    public LocalSessionFactoryBean sessionFactory()
    {
        String m = "";
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        try{
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setHibernateProperties(hibernateProperties());

            FileSystemResource resource4 = new FileSystemResource("./src/main/java/com/webDevelopment/inventorySytemDDD/Products/Product/Infrastructure/hibernate/CustomTypes.hbm.xml");
            FileSystemResource resource1 = new FileSystemResource("./src/main/java/com/webDevelopment/inventorySytemDDD/Products/Product/Infrastructure/hibernate/Product.hbm.xml");
            FileSystemResource resource2 = new FileSystemResource("./src/main/java/com/webDevelopment/inventorySytemDDD/Products/ProductColor/Infrastructure/hibernate/ProductColor.hbm.xml");
            FileSystemResource resource3 = new FileSystemResource("./src/main/java/com/webDevelopment/inventorySytemDDD/Orders/Order/Infrastructure/hibernate/Order.hbm.xml");

            sessionFactory.setMappingLocations(resource1, resource2, resource3, resource4);
        }
        catch (Throwable e)
        {
            m = e.getMessage();
        }
        return sessionFactory;
    }

    @Bean("transactional-manager")
    public PlatformTransactionManager hibernateTransactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private DataSource dataSource() {
        String url = env.getProperty("datasource.url");
        String userName = env.getProperty("datasource.username");
        String password = env.getProperty("datasource.password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mariadb://" + url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        return hibernateProperties;
    }
}
