package com.se.calc.services;

import com.se.calc.models.Pagamento;
import com.se.calc.models.Pedido;
import org.springframework.http.ResponseEntity;

public interface PagamentoService {
    String criaPagamento(Pagamento pagamento);
}
