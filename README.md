# Desafio Java Back-end - SoftExpert

O desafio está detalhado no link:

### Requisitos usados para o desenvolvimento:
+ Java 11
+ Spring boot
+ Documentação Swagger
+ Testes unitários JUnit5
+ Testes automatizados utilizando cucumber


## Tutorial
### Inicializar o projeto:
+ Para inicializar o projeto, faça o clone com o comando no seu git: "git clone https://github.com/ninexe/Se-Desafio-BackEnd.git"
+ Abra o repositório na sua IDE de preferência, e dê um build
+ Assim que a IDE baixar todas as dependências do projeto, clique em Run CalcApplication:
### ![image](https://user-images.githubusercontent.com/61746866/228234726-9574ce5c-d184-485b-9bcf-2f27b69f1e47.png)

### Acessar api Calculo
+ Para acessar a api pela documentação do Swagger acesse o caminho: http://localhost:8080/swagger-ui/index.html#/
+ Clique em Show/Hide
+ Acesse a Api pedidos/calcular, e siga o exemplo de consulta Ex:
### ![image](https://user-images.githubusercontent.com/61746866/228235168-abfb0e70-e03d-4f12-8017-7d4c85f2416b.png)
+ Aqui você pode adicionar varios clientes e com varios tipos de produtos, para calcular o valor proporcional para cada cliente pagar.
### Acessar api Pagamento
+ Para utilizar o pagamento via Mercado Pago, deverá ter acesso ao AcessToken configurado para sua empresa, segue o link para conseguir https://proximaweb.com.br/tutoriais/como-gerar-o-token-do-mercadopago-e-public-key-do-marcadopago-criado-em-2020/
+ Caso não tenha conseguido configurar o AcessToken, não tem problema, a api tem um gerador de QRcode em homologação.
+ Para acessar api de pagamento acesse pagamentos/gerar-pagamento
+ Clique em Show/Hide
+ Insira um email valido, uma descrição de produto, e o valor do mesmo:
### ![Studio_Project](https://user-images.githubusercontent.com/61746866/228237272-194d896b-9d4c-4437-8d16-505ffff103d7.gif)


### Utilizar Testes Unitarios e Automatizados
+ Para utilizar o teste Unitario, configure igual a imagem para rodar os testes do diretório completo.
### ![image](https://user-images.githubusercontent.com/61746866/228238806-759c73c2-0bfe-4d4b-b560-11300b4650aa.png)
+ Para utilizar o teste Automatizado, selecione "Feature: pedido-pagamento" e dê Run
### ![image](https://user-images.githubusercontent.com/61746866/228237641-59368a81-cf43-4dc9-bdd5-aa4888b327f2.png)

