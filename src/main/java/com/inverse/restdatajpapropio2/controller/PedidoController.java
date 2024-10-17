package com.inverse.restdatajpapropio2.controller;

import com.inverse.restdatajpapropio2.entities.Pedido;
import com.inverse.restdatajpapropio2.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {

    PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping("/api/pedidos")
    public List<Pedido> encontrarPedidos(){
        return pedidoRepository.findAll();
    }

    @GetMapping("/api/pedidos/{id}")
    public ResponseEntity<Pedido> encontrarPedido(@PathVariable Long id){
        Optional<Pedido> pedidoOp = pedidoRepository.findById(id);
        if(pedidoOp.isPresent()){
            return ResponseEntity.ok(pedidoOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/pedidos")
    public ResponseEntity<Pedido> agregarPedido(@RequestBody Pedido pedido){
        if(pedido.getId() != null){
            System.out.println("Pedido ya existe");
            return ResponseEntity.badRequest().build();
        }else{
            Pedido resultado = pedidoRepository.save(pedido);
            return ResponseEntity.ok(resultado);
        }

    }

    @PutMapping("/api/pedidos")
    public ResponseEntity<Pedido> modificarPedido(@RequestBody Pedido pedido){
        if(pedido.getId() == null){
            System.out.println("Pedido aun no existe");
            return ResponseEntity.badRequest().build();
        }
        if(!pedidoRepository.existsById(pedido.getId())){
            System.out.println("Pedido no existe porque tiene id incorrecto");
            return ResponseEntity.notFound().build();
        }
        Pedido result = pedidoRepository.save(pedido);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/pedidos/{id}")
    public ResponseEntity<Pedido> borrarPedido(@PathVariable Long id){
        if(pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            System.out.println("Intentas borrar un pedido que no existe");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/pedidos")
    public ResponseEntity<Pedido> borrarPedidos(){
        System.out.println("Borrando todo");
        pedidoRepository.deleteAll();
        return ResponseEntity.notFound().build();
    }
}
