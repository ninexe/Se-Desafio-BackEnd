package com.se.calc;

import com.se.calc.models.Cliente;
import com.se.calc.models.Item;
import com.se.calc.models.Pedido;
import com.se.calc.services.PedidoService;
import com.se.calc.services.PedidoServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Cucumber
@CucumberContextConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RunCucumberTest {

    @Mock
    private Pedido pedidoResponse;
    @InjectMocks
    private PedidoService pedidoService = new PedidoServiceImpl();
    private ArrayList<Pedido> pedido = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Item> item1 = new ArrayList<>();
    private ArrayList<Item> item2 = new ArrayList<>();
    @Given("um pedido valido")
    public void um_pedido_valido() {
        item1.add(new Item(null,"sanduiche",new BigDecimal(8)));
        item2.add(new Item(null,"hamburguer",new BigDecimal(40)));
        item2.add(new Item(null,"sobremesa",new BigDecimal(2)));
        clientes.add(new Cliente(null, "Gui", "gui@gmail.com", new BigDecimal(0),item1));
        clientes.add(new Cliente(null, "Pedro", "pedro@gmail.com", new BigDecimal(0),item2));
        pedido.add(new Pedido(null,new BigDecimal(20), new BigDecimal(8), new BigDecimal(38), clientes));
    }
    @When("o cliente realiza a consulta do calculo do pedido valido")
    public void o_cliente_realiza_a_consulta_do_calculo_do_pedido_valido() {
        pedidoResponse = pedidoService.calcPedidoClientes(pedido.get(0));
        // aqui é a consulta feita pelo cliente
    }
    @Then("as informacoes dos valores correspondentes sao retornadas")
    public void as_informacoes_dos_valores_correspondentes_sao_retornadas() {
        Assertions.assertEquals(pedidoResponse.getClientes().get(0).getValorTotalCliente(),
                new BigDecimal(6.08).setScale(2, RoundingMode.FLOOR));
        Assertions.assertEquals(pedidoResponse.getClientes().get(1).getValorTotalCliente(),
                new BigDecimal(31.92).setScale(2, RoundingMode.FLOOR));
        // aqui você pode verificar as informacoes dos valores correspondentes sao retornadas
    }
}
