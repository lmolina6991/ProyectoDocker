package com.example.docker_proy.repo;

import com.example.docker_proy.entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface MaquinaRepo extends JpaRepository<Maquina, String> {
}
