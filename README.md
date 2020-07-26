# delivery-bills

Obs: a opcao de usar o RabbitMQ para receber as requisicoes de pagamentos foi para exemplificar o desacoplamento que e'
possivel de ser feito numa arquitetura orientada a eventos, bem como a resiliencia de ter uma segunda opcao caso o 
broker esteja indisponivel (execucao ad-hoc) - praticas reativas. <br/>

Para executar a aplicacao, por favor, rode os seguintes comandos:

_./mvnw clean install <br/>
docker-compose up_

Exemplo de adicao de nova conta (use postman ou curl) na base localhost:8080:

resource: /invoices<br/>
method: POST<br/>
body:
`{
	"name": "fatura cartao de credito",
	"amount": 100,
	"dueDate": "2020-12-23T00:00:00.00",
	"paymentDate": "2020-12-24T00:00:00.00"
}`

Listagem:<br/>
resource: /invoices<br/>
method: GET<br/>