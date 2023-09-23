package com.example.docker_proy.controller;

import com.example.docker_proy.entity.Maquina;
import com.example.docker_proy.entity.Material;
import com.example.docker_proy.repo.MaquinaRepo;
import com.example.docker_proy.repo.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialRepo materialRepo;

    @GetMapping("/findAll")
    public List<Material> getAllMaterial() {
        return materialRepo.findAll();
    }
    @PostMapping("/insert")
    public Material insert(@RequestBody Material material) {
        return materialRepo.save(material);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMaterial(@PathVariable Long id) {
        materialRepo.deleteById(id);
        return ResponseEntity.ok("Material eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Material> findMaterial(@PathVariable Long id) {
        Optional<Material> materialOptional = materialRepo.findById(id);
        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            return ResponseEntity.ok(material);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material materialActualizado) {
        Optional<Material> materialExistente = materialRepo.findById(id);

        if (materialExistente.isPresent()) {
            Material material = materialExistente.get();

            // Actualiza los campos del material con los valores del material actualizado
            material.setNombre(materialActualizado.getNombre());

            // Guarda el material actualizado en la base de datos
            Material materialActualizadoEnBD = materialRepo.save(material);

            return ResponseEntity.ok(materialActualizadoEnBD);
        } else {
            // Si el material no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }
}

