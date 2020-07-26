# delivery-bills

Para executar a aplicacao, por favor, rode os seguintes comandos:

_./mvnw clean install <br/>
docker-compose up_

Exemplo de adicao de nova conta (use postman ou curl):

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