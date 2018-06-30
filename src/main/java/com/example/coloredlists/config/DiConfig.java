package com.example.coloredlists.config;

import com.example.coloredlists.Repositories.HibernateRepository;
import com.example.coloredlists.Repositories.base.GenericRepository;
import com.example.coloredlists.models.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiConfig {
    @Bean
    @Autowired
    GenericRepository<Item> provideGenericRepositor(SessionFactory sessionFactory){
        HibernateRepository<Item> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(Item.class);

        return repo;

    }
@Bean
  SessionFactory  ProvideSessionFactory(){
     return HibernateUtils.getSessionFactory();

    }
}
