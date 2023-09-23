package com.example.docker_proy.controller;

import com.example.docker_proy.entity.Material;
import com.example.docker_proy.entity.OrdenCompra;
import com.example.docker_proy.repo.MaterialRepo;
import com.example.docker_proy.repo.OrdenCompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orden_compra")
public class OrdenCompraController {
    @Autowired
    private OrdenCompraRepo ordenCompraRepo;

    @GetMapping("/findAll")
    public List<OrdenCompra> getAllOrdenCompra() {
        return ordenCompraRepo.findAll();
    }
    @PostMapping("/insert")
    public OrdenCompra insert(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraRepo.save(ordenCompra);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrdenCompra(@PathVariable Long id) {
        ordenCompraRepo.deleteById(id);
        return ResponseEntity.ok("OrdenCompra eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<OrdenCompra> findOrdenCompra(@PathVariable Long id) {
        Optional<OrdenCompra> ordenCompraOptional = ordenCompraRepo.findById(id);
        if (ordenCompraOptional.isPresent()) {
            OrdenCompra ordenCompra = ordenCompraOptional.get();
            return ResponseEntity.ok(ordenCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<OrdenCompra> updateOrdenCompra(@PathVariable Long id, @RequestBody OrdenCompra ordenCompraActualizado) {
        Optional<OrdenCompra> ordenCompraExistente = ordenCompraRepo.findById(id);

        if (ordenCompraExistente.isPresent()) {
            OrdenCompra ordenCompra = ordenCompraExistente.get();

            // Actualiza los campos del ordenCompra con los valores del ordenCompra actualizado
            ordenCompra.setFechaRealizacion(ordenCompraActualizado.getFechaRealizacion());
            ordenCompra.setFechaEntregaEsperada(ordenCompraActualizado.getFechaEntregaEsperada());
            ordenCompra.setFechaEntregaReal(ordenCompraActualizado.getFechaEntregaReal());
            ordenCompra.setCliente(ordenCompraActualizado.getCliente());

            // Guarda el ordenCompra actualizado en la base de datos
            OrdenCompra ordenCompraActualizadoEnBD = ordenCompraRepo.save(ordenCompra);

            return ResponseEntity.ok(ordenCompraActualizadoEnBD);
        } else {
            // Si el ordenCompra no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }
}