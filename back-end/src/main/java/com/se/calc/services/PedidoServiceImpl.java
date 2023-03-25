package com.se.calc.services;

import com.se.calc.models.Pedido;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl implements PedidoService{
    public Pedido calcPedidoClientes(Pedido pedido){

        for (int i = 0; i < pedido.getClientes().toArray().length; i++) {

            //Calcula a proporção pois podem ter varios clientes em um pedido
            Double proporcao = 100.0 / pedido.getClientes().toArray().length;
            Double valorTotalCliente = 0.0;

            for (int a = 0; a < pedido.getClientes().get(i).getItens().toArray().length; a++) {

                //Calcula separadamente o valor total de cada cliente pois podem ter varios itens pra cada cliente
                valorTotalCliente = valorTotalCliente + pedido.getClientes().get(i).getItens().get(a).getValorItem();
            }

            //calcula o valor proporcional para cada cliente
            pedido.getClientes().get(i).setValorTotalCliente((valorTotalCliente/proporcao) * pedido.getValorTotal());
        }

        return pedido;
    }

}
