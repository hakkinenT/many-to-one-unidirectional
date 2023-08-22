package com.example.manyToOneUnidirectional.repositories;

import com.example.manyToOneUnidirectional.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
