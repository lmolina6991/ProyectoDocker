package com.example.docker_proy.controller;

import com.example.docker_proy.entity.AsignacionMaquina;
import com.example.docker_proy.repo.AsignacionMaquinaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asignacion_maquina")
public class AsignacionMaquinaController {

    @Autowired
    private AsignacionMaquinaRepo asignacionMaquinaRepo;

    @GetMapping("/findAll")
    public List<AsignacionMaquina> getAllAsignacionMaquina() {
        return asignacionMaquinaRepo.findAll();
    }

    @PostMapping("/insert")
    public AsignacionMaquina insert(@RequestBody AsignacionMaquina asignacionMaquina) {
        return asignacionMaquinaRepo.save(asignacionMaquina);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAsignacionMaquina(@PathVariable Long id) {
        asignacionMaquinaRepo.deleteById(id);
        return ResponseEntity.ok("Maquina eliminada con éxito");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AsignacionMaquina> findAsignacionMaquina(@PathVariable Long id) {
        Optional<AsignacionMaquina> asignacionMaquinaOptional = asignacionMaquinaRepo.findById(id);
        if (asignacionMaquinaOptional.isPresent()) {
            AsignacionMaquina asignacionMaquina = (AsignacionMaquina) asignacionMaquinaOptional.get();
            return ResponseEntity.ok(asignacionMaquina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AsignacionMaquina> updateAsignacionMaquina(@PathVariable Long id, @RequestBody AsignacionMaquina asignacionMaquinaActualizado) {
        Optional<AsignacionMaquina> asignacionMaquinaExistente = asignacionMaquinaRepo.findById(id);

        if (asignacionMaquinaExistente.isPresent()) {
            AsignacionMaquina asignacionMaquina = asignacionMaquinaExistente.get();

            // Actualiza los campos de la maquina con los valores de la maquina actualizados

            asignacionMaquina.setIdTrabajador(asignacionMaquinaActualizado.getIdTrabajador());
            asignacionMaquina.setNumSerie(asignacionMaquinaActualizado.getNumSerie());

            // Guarda la maquina actualizada en la base de datos
            AsignacionMaquina asignacionMaquinaActualizadoEnBD = asignacionMaquinaRepo.save(asignacionMaquina);

            return ResponseEntity.ok(asignacionMaquinaActualizadoEnBD);
        } else {
            // Si la maquina no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }
}