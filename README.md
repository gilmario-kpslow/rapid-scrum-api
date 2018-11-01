# Rapid Scrum

Projeto com o obetivo de criar um ferramenta de controle de Projeto baseado na 
metodologia Scrum

## Getting Started

Para rodar projeto baixe o codigo fonte entre na pasta do projeto e execute o build com o maven
ex: mvn clean package skipTests=true
    java -jar rapidscrum-0.0.1-SNAPSHOT.jar

### Prerequisites

Maven 3.5 ou superior
Java 8_152 ou superior
Postgresql 9.6 ou superior
criar um banco de dados com o nome rapidscrumdb com as seguintes credencias
usuario: postgres
senha: postgres

você pode editar essa informações no arquivo src/main/java/resources/application.properties

```
Acesse http://localhost:8080/status para ver se existe resposta do status.