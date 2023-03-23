package com.se.calc.controllers;

import com.se.calc.models.Cliente;
import com.se.calc.models.Pedido;
import com.se.calc.repositorys.PedidoRepository;
import com.se.calc.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/solicitar")
@RestController
@AllArgsConstructor
@CrossOrigin
public class PedidoController {

    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.getClientes();
    }

    /*@GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        //Pedido pedidoModel = pedidoService.calcPedidoClientes();
        List<Pedido> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido){
        Pedido entidade = repository.save(pedido);
        return ResponseEntity.ok(entidade);
    }*/
    @PostMapping(value = "/pedidosave")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido Add(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }
}
