
# Good Food

GoodFood é uma aplicação que provê um software de gerenciamento para uma lanchonete em expansão.


# DDD
O DDD do projeto está disponibilizado no [Miro](https://miro.com/app/board/uXjVKTxXwGc=/?share_link_id=520536120828).

# Tecnologias

Tecnologias utilizadas
- Java
- Springboot
- Maven
Banco de dados:
- PostegreSQL 16


# Build
O projeto poderá ser empacotado e "buildado" através do arquivo [Dockerfile](https://github.com/carlosbridi/goodfood-postech/blob/main/Dockefile).

# Rodando o projeto

O repositório Git contém um arquivo [docker-compose.yml](https://github.com/carlosbridi/goodfood-postech/blob/main/docker-compose.yml), copie esse arquivo para um diretório local, certifique-se que contém o [Docker Compose](https://docs.docker.com/compose/install/) instalado.

Rodar o comando `docker-compose up -d`, assim que o download das imagens do banco e da aplicação forem finalizadas, o projeto estará rodando na porta 8080, sendo possível acessar o swagger atrás do link: http://localhost:8080/swagger-ui/index.html.


# Endpoints
  Identificar o controller e a doc


# Rever
Error 500

UseCase com interface


# Equipe
Carlos Bridi - RM355971

Nicollas Eissemann - RM355576

Daniel R. Martini - RM355054

Roberto Debarba - RM355038
