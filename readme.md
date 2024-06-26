
# Projeto desafio de testes Web e API

## Descrição

Projeto de automação de testes Web e API 

## Tecnologias

- Java 21
- Maven
- JUnit
- RestAssured
- Selenium WebDriver
- Cucumber

## Estrutura do projeto

```
src
│test
│  ├─java
│  │  ├─org
│  │  │  ├─texo
│  │  │  │  ├─pages
│  │  │  │  │  ├─BasePage.java
│  │  │  │  |─steps
│  │  │  │  │  ├─Web
│  │  │  │  │  │  ├─WebSteps.java
│  │  │  │  │  ├─Api
│  │  │  │  │  │  ├─ApiSteps.java
│  │  │  │  |─RunCucumberTest.java
│  ├─resources
│  │  ├─org
│  │  │  ├─texo
│  │  │  │  ├─web
│  │  │  ││    ├─web.feature
│  │  │  │  ├─api
│  │  │  │  │  ├─api.feature
.gitignore
pom.xml
README.md
```

## Execução

Para executar o projeto, basta executar o comando abaixo:

```
mvn test
```

## Relatório

O relatório de execução dos testes é gerado na pasta `target/cucumber-reports` em formato HTML.


## Autor

- [Deovan Zanol](https://www.linkedin.com/in/deovan-zanol/)
