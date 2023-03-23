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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_item", nullable = false)
    private Long cdItem;
    @Column(name = "nm_item", nullable = false)
    private String nomeItem;
    @Column(name = "nr_valor", nullable = false)
    private Double valorItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinTable(name = "item_has_cliente",	joinColumns = { @JoinColumn(name = "cd_item") },inverseJoinColumns = { @JoinColumn(name = "cd_cliente") })
    @JsonIgnoreProperties
    @JsonBackReference
    @JsonIgnore
    private Cliente cliente;
}
