Feature: Consulta de CEP

  Scenario: Consultar PEDIDO válido
    Given um pedido valido
    When o cliente realiza a consulta do calculo do pedido valido
    Then as informacoes dos valores correspondentes sao retornadas