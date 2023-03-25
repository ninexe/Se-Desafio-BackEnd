package com.se.calc.controllers;

import com.se.calc.models.Pagamento;
import com.se.calc.models.Pedido;
import com.se.calc.services.PagamentoService;
import com.se.calc.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pagamentos")
@RestController
@AllArgsConstructor
@CrossOrigin
public class PagamentoController {

    private PagamentoService pagamentoService;
    @PostMapping("/gerarPagamento")
    public ResponseEntity pagar(@RequestBody Pagamento pagamento){
        ResponseEntity response = pagamentoService.criaPagamento(pagamento);
        return new ResponseEntity(response,response.getStatusCode());
    }
}
