package application.conf;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("properties/connection.properties")
@ComponentScans(value = { @ComponentScan("application.model"),
        @ComponentScan("application.core") })
public class HibernateConfiguration {

    private @Value("hibernate.connection.driver_class") String driverClass;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://18.222.36.80:3306/CODE_MERGERS?useSSL=false");
        dataSource.setUsername("remote");
        dataSource.setPassword("remote");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("application.model");
        sessionFactory.setMappingResources("hbms/user.cfg.xml");
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.ISOLATION, "2");
        properties.put(AvailableSettings.C3P0_ACQUIRE_INCREMENT, "1");
        properties.put(AvailableSettings.C3P0_IDLE_TEST_PERIOD, "300");
        properties.put(AvailableSettings.C3P0_TIMEOUT, "600");
        properties.put(AvailableSettings.C3P0_MAX_SIZE, "25");
        properties.put(AvailableSettings.C3P0_MIN_SIZE, "1");
        properties.put(AvailableSettings.C3P0_MAX_STATEMENTS, "0");
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(getSessionFactory().getObject());
        return txManager;
    }
}
