package mx.unam.pa.spring.cli.hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Clase de configuración para indicar a Hibernate que 
 * parámetros debe usar para abrir la sesión (conexión) 
 * con la base de datos.
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 12:01:56 PM
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan( basePackages = {"mx.unam.pa.spring.cli.hibernate"} )
public class HibernateConfig {
	@Autowired
    private ApplicationContext context;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        return sessionFactory;
    }
	
	@Bean
    public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
