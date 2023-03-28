package com.se.calc;

import com.se.calc.models.Cliente;
import com.se.calc.models.Item;
import com.se.calc.models.Pedido;
import com.se.calc.services.PedidoService;
import com.se.calc.services.PedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@SpringBootTest
class PedidoTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private Pedido pedidoResponse;
	@InjectMocks
	private PedidoService pedidoService = new PedidoServiceImpl();
	private ArrayList<Pedido> pedido = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Item> item1 = new ArrayList<>();
	private ArrayList<Item> item2 = new ArrayList<>();

	@Test
	void testConsultaPedido(){
		item1.add(new Item(null,"sanduiche",new BigDecimal(8)));
		item2.add(new Item(null,"hamburguer",new BigDecimal(40)));
		item2.add(new Item(null,"sobremesa",new BigDecimal(2)));
		clientes.add(new Cliente(null, "Gui", "gui@gmail.com", new BigDecimal(0),item1));
		clientes.add(new Cliente(null, "Pedro", "pedro@gmail.com", new BigDecimal(0),item2));
		pedido.add(new Pedido(null,new BigDecimal(20), new BigDecimal(8), new BigDecimal(38), clientes));

		pedidoResponse = pedidoService.calcPedidoClientes(pedido.get(0));
		Assertions.assertEquals(pedidoResponse.getClientes().get(0).getValorTotalCliente(),
				new BigDecimal(6.08).setScale(2, RoundingMode.FLOOR));
		Assertions.assertEquals(pedidoResponse.getClientes().get(1).getValorTotalCliente(),
				new BigDecimal(31.92).setScale(2, RoundingMode.FLOOR));
	}

}
