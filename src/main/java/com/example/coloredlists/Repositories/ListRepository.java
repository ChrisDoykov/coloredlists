package com.example.coloredlists.Repositories;

import com.example.coloredlists.models.List;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
}
