package com.se.calc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long id;
    @Column(name = "nm_item", nullable = false)
    private String nomeItem;
    @Column(name = "nr_valor", nullable = false)
    private Double valorItem;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_has_item",	joinColumns = { @JoinColumn(name = "cliente_id") },inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private Cliente cliente;
}
