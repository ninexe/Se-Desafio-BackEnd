package com.se.calc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;
    private String nomeItem;
    private BigDecimal valorItem;

}
