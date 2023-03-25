package com.se.calc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    private String email;
    private String descricaoPagamento;
    private String tokenCardPagamento;
    private int tipoCartao;
    private BigDecimal valorTotalPagamento;

}
