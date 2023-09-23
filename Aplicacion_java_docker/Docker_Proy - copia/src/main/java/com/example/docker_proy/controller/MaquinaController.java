package com.example.docker_proy.controller;

import com.example.docker_proy.entity.Maquina;
import com.example.docker_proy.repo.MaquinaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaRepo maquinaRepo;

    @GetMapping("/findAll")
    public List<Maquina> getAllMaquina() {
        return maquinaRepo.findAll();
    }
    @PostMapping("/insert")
    public Maquina insert(@RequestBody Maquina maquina) {
        return maquinaRepo.save(maquina);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMaquina(@PathVariable String id) {
        maquinaRepo.deleteById(id);
        return ResponseEntity.ok("Maquina eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Maquina> findMaquina(@PathVariable String id) {
        Optional<Maquina> maquinaOptional = maquinaRepo.findById(id);
        if (maquinaOptional.isPresent()) {
            Maquina maquina = maquinaOptional.get();
            return ResponseEntity.ok(maquina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Maquina> updateMaquina(@PathVariable String id, @RequestBody Maquina maquinaActualizado) {
        Optional<Maquina> maquinaExistente = maquinaRepo.findById(id);

        if (maquinaExistente.isPresent()) {
            Maquina maquina = maquinaExistente.get();

            // Actualiza los campos de la maquina con los valores del maquina actualizado
            maquina.setMarca(maquinaActualizado.getMarca());
            maquina.setModelo(maquinaActualizado.getModelo());
            maquina.setFechaCompra(maquinaActualizado.getFechaCompra());


            // Guarda el maquina actualizado en la base de datos
            Maquina maquinaActualizadoEnBD = maquinaRepo.save(maquina);

            return ResponseEntity.ok(maquinaActualizadoEnBD);
        } else {
            // Si el maquina no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }
}
