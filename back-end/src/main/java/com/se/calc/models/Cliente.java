package com.se.calc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cliente", nullable = false)
    private Long cdCliente;
    @Column(name = "nm_cliente", nullable = false)
    private String nome;
    @Column(name = "nm_item", nullable = false)
    private String nomeItem;
    @Column(name = "nr_valor", nullable = false)
    private Double valorItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinTable(name = "cliente_has_pedido",	joinColumns = { @JoinColumn(name = "cd_cliente") },inverseJoinColumns = { @JoinColumn(name = "cd_pedido") })
    @JsonIgnoreProperties
    @JsonBackReference
    @JsonIgnore
    private Pedido pedido;
}
