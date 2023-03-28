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
    @PostMapping("/gerar-pagamento")
    public ResponseEntity<String> pagar(@RequestBody Pagamento pagamento){
        String linkPagamento = pagamentoService.criaPagamento(pagamento);
        return ResponseEntity.ok(linkPagamento);
    }
}
