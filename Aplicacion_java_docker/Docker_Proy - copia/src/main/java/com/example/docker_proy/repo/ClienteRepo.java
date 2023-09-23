package com.example.docker_proy.repo;

import com.example.docker_proy.entity.Cliente;
import com.example.docker_proy.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}

