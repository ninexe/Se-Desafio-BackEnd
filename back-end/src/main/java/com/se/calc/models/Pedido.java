package com.se.calc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private Long id;
    private BigDecimal desconto;
    private BigDecimal frete;
    private Double valorTotal;
    private List<Cliente> clientes = new ArrayList<>();

}
