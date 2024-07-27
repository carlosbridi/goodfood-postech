
# Good Food

GoodFood é uma aplicação que provê um software de gerenciamento para uma lanchonete em expansão.

# Desafio

As descrições dos desafios de cada fase estão na pasta /doc/tech-challenge.
As resoluções por fase estão nas tags do git fase1-*, fase2-*, etc.


# DDD
O DDD do projeto está disponibilizado no [Miro](https://miro.com/app/board/uXjVKTxXwGc=/?share_link_id=520536120828) ou na pasta /doc/ddd (baixa qualidade).


# Arquitetura Clean Architecture

Baseado em [Clean Architecture with Spring Boot](https://www.baeldung.com/spring-boot-clean-architecture)
![clean-arch](/doc/clean-architecture.jpg?raw=true)


# Tecnologias

Tecnologias utilizadas
- Java
- Springboot
- Maven
- Banco de dados:
- PostegreSQL 16


# Build
O projeto poderá ser empacotado e "buildado" através do arquivo [Dockerfile](https://github.com/carlosbridi/goodfood-postech/blob/main/Dockefile).

# Rodando o projeto

O repositório Git contém um arquivo [docker-compose.yml](https://github.com/carlosbridi/goodfood-postech/blob/main/docker-compose.yml), copie esse arquivo para um diretório local, certifique-se que contém o [Docker Compose](https://docs.docker.com/compose/install/) instalado.

Rodar o comando `docker-compose up -d`, assim que o download das imagens do banco e da aplicação forem finalizadas, o projeto estará rodando na porta 8080, sendo possível acessar o swagger atrás do link: http://localhost:8080/swagger-ui/index.html.

# Kubernetes 

Arquivos do K8S está na pasta "k8s".
 * **HPA** - hpa-goodfood-postech.yaml
 * **Deployment** - pod-goodfood-postech.yaml
 * **SVC Cluster IP DB** - svc-cluster-ip-postgres.yaml
 * **SVC DB** - svc-postgres.yaml
 * **LoadBalancer** - svc-goodfood-postech-loadbalancer.yaml
 
Para executar o projeto em um cluster, basta executar todos os arquivos acima com o comando `kubectl apply -f .`, obter o IP a partir do `kubectl get svc` e acessar a URL `http:\\<ip>/swagger/index.html`

# Testes
Para rodar os testes, basta rodar o comando `mvn test` na raiz do projeto.
Atualmente os testes apenas validam as dependências entre os pacotes, garantindo a correta implementação da arquitetura clean architecture.

# Endpoints
Abaixo segue os endpoint junto com seus respectivos request body.
Vale a pena ressaltar a necessidade de substituir os textos **{id}** pelos IDs gerados em outros responses.

## Produto-controller

Endpoints do produto
### put /produto/{id}
Necessário preencher o **ID** do produto
```javascript
{
  "descricao": "HAMBURGER",
  "preco": 15.9,
  "categoria": "LANCHE"
}
```
### get /produto/{categoria}
Necessário substituir **{categoria}** por umas das seguintes opções:
* LANCHE
* BEBIDA
* ACOMPANHAMENTO
* SOBREMESA
### post /produto
```javascript
{
  "descricao": "HAMBURGER",
  "preco": 15.9,
  "categoria": "LANCHE"
}
```
### delete /produto/{produtoId}
Necessário preencher o **ID** do produto
```javascript
{
  "descricao": "HAMBURGER",
  "preco": 15.9,
  "categoria": "LANCHE"
}
```
## Pedido-controller

Endpoints do pedido

### put /pedido/{id}/adicionarProduto
Necessário preencher o **ID** do pedido
```
{
  "clienteCPF": "<id>",
  "itemPedidos": [
    {
      "produtoUUID": "<id>",
      "observacoes": "Teste 123",
      "quantidade": 1
    }
  ]
}
```
### get /pedido/
Não necessário passar parâmetros para o swagger.
### get /pedido/{id}
ID do pedido.
### post /pedido
Necessário preencher o **ID** do pedido
```
{
  "clienteCPF": "<id>",
  "itemPedidos": [
    {
      "produtoUUID": "<id>",
      "observacoes": "Teste 123",
      "quantidade": 1
    }
  ]
}
```
### post /pedido/regredir-status/{id}
Necessário apenas preencher o **ID** do pedido
### post /pedido/avancar-status/{id}
Necessário apenas preencher o **ID** do pedido
### delete /pedido/{id}
Necessário preencher o **ID** do pedido
```
{
  "clienteCPF": "<id>",
  "itemPedidos": [
    {
      "produtoUUID": "<id>",
      "observacoes": "Teste 123",
      "quantidade": 1
    }
  ]
}
```
### Cliente-controller
Endpoints do cliente

### post /cliente
```
{
  "nome": "Usuário de teste",
  "cpf": "123.456.789-10"
}
```
### get /cliente/buscar-cpf/{cpf}
Apenas precisa preencher o CPF

# Equipe
Carlos Bridi - RM355971
Nicollas Eissemann - RM355576
Daniel R. Martini - RM355054
Roberto Debarba - RM355038

