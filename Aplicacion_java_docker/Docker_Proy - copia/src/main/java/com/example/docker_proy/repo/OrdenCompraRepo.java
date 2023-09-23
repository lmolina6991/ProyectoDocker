package com.example.docker_proy.repo;

import com.example.docker_proy.entity.Material;
import com.example.docker_proy.entity.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepo extends JpaRepository<OrdenCompra, Long> {

}
