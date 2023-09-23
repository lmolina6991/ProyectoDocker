package com.example.docker_proy.repo;

import com.example.docker_proy.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Long > {
}

