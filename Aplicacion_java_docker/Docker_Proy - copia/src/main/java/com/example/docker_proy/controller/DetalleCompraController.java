package com.example.docker_proy.controller;

import com.example.docker_proy.entity.DetalleCompra;
import com.example.docker_proy.repo.DetalleCompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle_compra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;
    @GetMapping("/findAll")
    public  List<DetalleCompra>getAllDetalleCompra () {
        return detalleCompraRepo.findAll();
    }
    @PostMapping("/insert")
    public DetalleCompra insert(@RequestBody DetalleCompra detalleCompra){
        return  detalleCompraRepo.save(detalleCompra);}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetalleCompra(@PathVariable Long id) {
        detalleCompraRepo.deleteById(id);
        return ResponseEntity.ok("detalle de compra eliminado con éxito");}

    @GetMapping("/find/{id}")
    public ResponseEntity<DetalleCompra> findDetalleCompra(@PathVariable Long id) {
        Optional<DetalleCompra> detalleCompraOptional = detalleCompraRepo.findById(id);
        if (detalleCompraOptional.isPresent()) {
            DetalleCompra detalleCompra = detalleCompraOptional.get();
            return ResponseEntity.ok(detalleCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DetalleCompra> updateDetalleCompra(@PathVariable Long id, @RequestBody DetalleCompra detalleCompraActualizado) {
        Optional<DetalleCompra> detalleCompraExistente = detalleCompraRepo.findById(id);

        if (detalleCompraExistente.isPresent()) {
            DetalleCompra detalleCompra = detalleCompraExistente.get();

            // Actualiza los campos del detalleCompra con los valores del detalleCompra actualizado
            detalleCompra.setIdOrden(detalleCompraActualizado.getIdOrden());
            detalleCompra.setIdProducto(detalleCompraActualizado.getIdProducto());
            detalleCompra.setCantidad(detalleCompraActualizado.getCantidad());
            detalleCompra.setPrecio(detalleCompraActualizado.getPrecio());

            // Guarda el detalleCompra actualizado en la base de datos
            DetalleCompra detalleCompraActualizadoEnBD = detalleCompraRepo.save(detalleCompra);

            return ResponseEntity.ok(detalleCompraActualizadoEnBD);
        } else {
            // Si el detalleCompra no se encuentra en la base de datos, devuelve un estado 404 (No encontrado)
            return ResponseEntity.notFound().build();
        }
    }

}
