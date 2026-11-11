# TFPOO-Prj

Projeto criado automaticamente com:

- Java 25
- Spring Boot 4.1.0
- Vaadin 25.2.1
- Maven

## Executar em modo de desenvolvimento

```bash
mvn spring-boot:run
```

Depois acesse:

```text
http://localhost:8080
```

## Executar os testes

```bash
mvn test
```

## Gerar pacote de desenvolvimento

```bash
mvn clean package
```

## Gerar pacote de produção

```bash
mvn clean package -Pproduction
```

O arquivo gerado estará em:

```text
target/TFPOO-Prj-1.0-SNAPSHOT.jar
```

## Executar o JAR

```bash
java -jar target/TFPOO-Prj-1.0-SNAPSHOT.jar
```
