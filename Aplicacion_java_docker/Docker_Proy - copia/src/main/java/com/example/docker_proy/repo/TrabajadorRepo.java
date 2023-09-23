package com.example.docker_proy.repo;

import com.example.docker_proy.entity.Material;
import com.example.docker_proy.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepo extends JpaRepository<Trabajador, Long> {
}
