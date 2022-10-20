package self.izouir.meetupapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("self.izouir.meetupapi")
public class ApplicationConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactory(final DataSource dataSource) {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("self.izouir.meetupapi.entity");

        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "false");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
