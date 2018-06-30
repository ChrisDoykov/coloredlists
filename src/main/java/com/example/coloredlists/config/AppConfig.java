package com.example.coloredlists.config;

import com.example.coloredlists.Repositories.base.GenericRepository;
import com.example.coloredlists.Repositories.HibernateRepository;
import com.example.coloredlists.models.Item;
import com.example.coloredlists.models.User;
import com.example.coloredlists.utils.validators.ItemValidator;
import com.example.coloredlists.utils.validators.base.Validator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;

@Configuration
public class AppConfig {
    @Bean
    @Autowired
    GenericRepository<Item> provideProductsGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<Item> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(Item.class);

        return repo;
    }


    @Bean
    @Autowired
    GenericRepository<User> provideUsersGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<User> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(User.class);

        return repo;
    }

    @Bean
    SessionFactory provideSessionFactory() {
        return com.example.coloredlists.config.HibernateUtils.getSessionFactory();
    }

    @Bean
    Validator<Item> provideItemValidator() {
        return new ItemValidator();
    }
    @Autowired
    javax.sql.DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        //JpaVendorAdapteradapter can be autowired as well if it's configured in application properties.
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        //Add package to scan for entities.
        factory.setPackagesToScan("com.example.coloredlists");
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}

