package com.se.calc.services;

import com.se.calc.models.Cliente;
import com.se.calc.models.Item;
import com.se.calc.models.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


@Service
public class PedidoServiceImpl implements PedidoService {
    public Pedido calcPedidoClientes(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalStateException("Informe um pedido!");
        } else {
            for (Cliente cliente : pedido.getClientes()) {
                //Calcula a proporção pois podem ter varios clientes em um pedido
                BigDecimal proporcao = new BigDecimal("100").divide(new BigDecimal(pedido.getClientes().size()), 2,
                        RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
                BigDecimal valorTotalCliente = BigDecimal.ZERO;

                for (Item item : cliente.getItens()) {
                    //Calcula separadamente o valor total de cada cliente pois podem ter varios itens pra cada cliente
                    valorTotalCliente = valorTotalCliente.add(item.getValorItem());
                }
                //calcula o valor proporcional para cada cliente
                cliente.setValorTotalCliente((valorTotalCliente.divide(proporcao, 2, RoundingMode.HALF_UP)
                        .setScale(2, RoundingMode.HALF_UP)).multiply(pedido.getValorTotal())
                        .setScale(2, RoundingMode.HALF_UP));
            }
        }
        return pedido;
    }
}
