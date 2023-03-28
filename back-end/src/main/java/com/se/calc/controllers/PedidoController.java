package com.se.calc.controllers;

import com.se.calc.models.Pedido;
import com.se.calc.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pedidos")
@RestController
@AllArgsConstructor
@CrossOrigin
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping("/calcular")
    public ResponseEntity<Pedido> calcularPedido(@RequestBody Pedido pedido){
        Pedido entidade = pedidoService.calcPedidoClientes(pedido);
        return ResponseEntity.ok(entidade);
    }
}
