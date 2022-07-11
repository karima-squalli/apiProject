package com.apiproject.data.repository;

import com.apiproject.data.model.Client;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
