package com.se.calc.services;

import com.se.calc.models.Cliente;
import com.se.calc.models.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido calcPedidoClientes();
    List <Pedido> getClientes();
    Pedido salvar(Pedido pedido);
}
