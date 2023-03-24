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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Long id;
    @Column(name = "nm_cliente", nullable = false)
    private String nome;
    @Column(name = "nr_valor_total_cliente", nullable = true)
    private Double valorTotalCliente;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_has_cliente",	joinColumns = { @JoinColumn(name = "pedido_id") },inverseJoinColumns = { @JoinColumn(name = "cliente_id") })
    private Pedido pedido;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens =  new ArrayList<>();
}
//