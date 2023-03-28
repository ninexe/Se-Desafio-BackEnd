package com.se.calc;

import com.se.calc.models.Pagamento;
import com.se.calc.services.PagamentoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
class PagamentoTests {

	@Test
	void contextLoads() {
	}

	private String pagamentoResponse;
	@InjectMocks
	private PagamentoServiceImpl pagamentoServiceImpl = new PagamentoServiceImpl();


	private ArrayList<Pagamento> pagamento = new ArrayList<>();
	@Test
	void testConsultaPedido(){

		pagamento.add(new Pagamento("gui@gmail.com","sanduiche",
				null, 1,new BigDecimal(6.08)));
		pagamento.add(new Pagamento("pedro@gmail.com","sanduiche",
				null, 1,new BigDecimal(31.92)));

		pagamentoResponse = pagamentoServiceImpl.criaPagamento(pagamento.get(0));
		assert (pagamentoResponse != null || pagamentoResponse.isEmpty());

	}

}
