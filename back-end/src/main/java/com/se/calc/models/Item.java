package com.se.calc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;
    private String nomeItem;
    private Double valorItem;

}
