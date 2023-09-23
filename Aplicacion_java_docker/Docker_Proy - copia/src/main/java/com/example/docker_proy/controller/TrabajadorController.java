package com.example.docker_proy.controller;

import com.example.docker_proy.entity.Producto;
import com.example.docker_proy.entity.Trabajador;
import com.example.docker_proy.repo.ProductoRepo;
import com.example.docker_proy.repo.TrabajadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    private TrabajadorRepo trabajadorRepo;

    @GetMapping("/findAll")
    public List<Trabajador> getAllTrabajador() {
        return trabajadorRepo.findAll();
    }
    @PostMapping("/insert")
    public Trabajador insert(@RequestBody Trabajador trabajador) {
        return trabajadorRepo.save(trabajador);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrabajador(@PathVariable Long id) {
        trabajadorRepo.deleteById(id);
        return ResponseEntity.ok("Trabajador eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Trabajador> findTrabajador(@PathVariable Long id) {
        Optional<Trabajador> trabajadorOptional = trabajadorRepo.findById(id);
        if (trabajadorOptional.isPresent()) {
            Trabajador trabajador = trabajadorOptional.get();
            return ResponseEntity.ok(trabajador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Trabajador> updateTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajadorActualizado) {
        Optional<Trabajador> trabajadorExistente = trabajadorRepo.findById(id);

        if (trabajadorExistente.isPresent()) {
            Trabajador trabajador = trabajadorExistente.get();

            // Actualiza los campos del trabajador con los valores del trabajador actualizado
            trabajador.setNombre(trabajadorActualizado.getNombre());
            trabajador.setFechaNacimiento(trabajadorActualizado.getFechaNacimiento());
            trabajador.setDireccion(trabajadorActualizado.getDireccion());


            // Guarda el trabajador actualizado en la base de datos
            Trabajador trabajadorActualizadoEnBD = trabajadorRepo.save(trabajador);

            return ResponseEntity.ok(trabajadorActualizadoEnBD);
        } else {
            // Si el trabajador no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }}
