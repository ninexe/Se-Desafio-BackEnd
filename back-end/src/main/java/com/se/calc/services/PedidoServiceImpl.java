package com.se.calc.services;

import com.se.calc.models.Cliente;
import com.se.calc.models.Pedido;
import com.se.calc.repositorys.ClienteRepository;
import com.se.calc.repositorys.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PedidoServiceImpl implements PedidoService{


    private ClienteService clienteService;

    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository, ClienteService clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public Pedido calcPedidoClientes(){

        List<Cliente> clientes = null;

/*
        response.getClientes().get(0).setNome("Gui");
        response.getClientes().get(0).getItens().get(0).setNomeItem("Hamburguer");
        response.getClientes().get(0).getItens().get(0).setValorItem(30.00);


        response.getClientes().get(1).setNome("Ramon");
        response.getClientes().get(1).getItens().get(0).setNomeItem("sanduiche");
        response.getClientes().get(1).getItens().get(0).setValorItem(8.00);



        response.setFrete(5.00);
        response.setDesconto(2.00);
        Double valorTotal= 0.0;
        Double proporcao = 0.0;
        Double freteDividido = 0.0;
        for (int i = 0; i < response.getClientes().toArray().length; i++) {
            proporcao = 100.0 / clientes.toArray().length;
            freteDividido = response.getFrete() / clientes.toArray().length;
            Double valorTotalCliente = 0.0;
            for (int a = 0; a < response.getClientes().get(i).getItens().toArray().length; a++) {

                valorTotalCliente = valorTotalCliente + response.getClientes().get(i).getItens().get(a).getValorItem();

                valorTotal = valorTotal + clientes.get(i).getItens().get(a).getValorItem();

            }
            //response.getClientes().get(i).setValorTotalCliente((valorTotalCliente + freteDividido)/proporcao );
        }
        response.setValorTotal(valorTotal + response.getFrete() - response.getDesconto());


*/
        return null;
    }

    @Override
    public List<Pedido> getClientes() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional
    public Pedido salvar(final Pedido pedido) {
        Pedido entity = new Pedido();

        var clientes = clienteService.salvarClientes(pedido.getClientes());

        entity.setCdPedido(pedido.getCdPedido());
        entity.setDesconto(pedido.getDesconto());
        entity.setFrete(pedido.getFrete());
        entity.setValorTotal(pedido.getValorTotal());
        entity.setClientes(clientes);

        return pedidoRepository.save(entity);
    }


}
