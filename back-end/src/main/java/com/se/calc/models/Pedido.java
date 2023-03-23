package com.se.calc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pedido", nullable = false)
    private Long cdPedido;
    @Column(name = "nr_desconto", nullable = false)
    private Double desconto;
    @Column(name = "nr_frete", nullable = false)
    private Double frete;
    @Column(name = "nr_valor_total", nullable = false)
    private Double valorTotal;
    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Cliente> clientes =  new ArrayList();

}
