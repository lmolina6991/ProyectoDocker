package com.example.docker_proy.controller;

import com.example.docker_proy.entity.Material;
import com.example.docker_proy.entity.Producto;
import com.example.docker_proy.repo.MaterialRepo;
import com.example.docker_proy.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class PoductoController {
    @Autowired
    private ProductoRepo productoRepo;

    @GetMapping("/findAll")
    public List<Producto> getAllProducto() {
        return productoRepo.findAll();
    }
    @PostMapping("/insert")
    public Producto insert(@RequestBody Producto producto) {
        return productoRepo.save(producto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        productoRepo.deleteById(id);
        return ResponseEntity.ok("Producto eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Producto> findProducto(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoRepo.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Optional<Producto> productoExistente = productoRepo.findById(id);

        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();

            // Actualiza los campos del producto con los valores del producto actualizado
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setTipoProducto(productoActualizado.getTipoProducto());
            producto.setMaterial(productoActualizado.getMaterial());
            producto.setNumSerie(productoActualizado.getNumSerie());

            // Guarda el producto actualizado en la base de datos
            Producto productoActualizadoEnBD = productoRepo.save(producto);

            return ResponseEntity.ok(productoActualizadoEnBD);
        } else {
            // Si el producto no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }}
