package com.example.docker_proy.repo;

import com.example.docker_proy.entity.Cliente;
import com.example.docker_proy.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepo extends JpaRepository<Material, Long> {
}
