package com.example.docker_proy.controller;

import com.example.docker_proy.entity.AsignacionMaquina;
import com.example.docker_proy.entity.Cliente;
import com.example.docker_proy.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping("/findAll")
    public List<Cliente> getAllCliente() {
        return clienteRepo.findAll();
    }
    @PostMapping("/insert")
    public Cliente insert(@RequestBody Cliente cliente) {
        return clienteRepo.save(cliente);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        clienteRepo.deleteById(id);
        return ResponseEntity.ok("Cliente eliminado con éxito");
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepo.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepo.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            // Actualiza los campos del cliente con los valores del cliente actualizado
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setDireccion(clienteActualizado.getDireccion());
            cliente.setTelefono(clienteActualizado.getTelefono());
            cliente.setPersonaContacto(clienteActualizado.getPersonaContacto());

            // Guarda el cliente actualizado en la base de datos
            Cliente clienteActualizadoEnBD = clienteRepo.save(cliente);

            return ResponseEntity.ok(clienteActualizadoEnBD);
        } else {
            // Si el cliente no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }

}