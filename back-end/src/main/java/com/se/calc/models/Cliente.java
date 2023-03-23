package com.se.calc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cliente", nullable = false)
    private Long cdCliente;
    @Column(name = "nm_cliente", nullable = false)
    private String nome;
    @Column(name = "nr_valor_total_cliente", nullable = false)
    private Double valorTotalCliente;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = true )
    @JoinTable(name = "cliente_has_pedido",	joinColumns = { @JoinColumn(name = "cd_cliente") },inverseJoinColumns = { @JoinColumn(name = "cd_pedido") })
    @JsonIgnoreProperties
    @JsonBackReference
    @JsonIgnore
    private Pedido pedido;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens =  new ArrayList();
}
