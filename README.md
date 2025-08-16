# Store Sales Clean API

## Sobre o Projeto
Store Sales Clean API é uma aplicação Spring Boot desenvolvida para gerenciar vendas de uma loja. A API permite o gerenciamento de produtos e categorias, seguindo os princípios de Clean Architecture e SOLID.

## Arquitetura Limpa (Clean Architecture)

Este projeto implementa os princípios da Arquitetura Limpa (Clean Architecture) proposta por Robert C. Martin. A estrutura do projeto é organizada em camadas concêntricas:

### 1. Core (Núcleo)
O centro da aplicação contém:
- **Domain**: Entidades de negócio (Product, Category) que representam os conceitos fundamentais do domínio.
- **Use Cases**: Implementação das regras de negócio específicas da aplicação.
- **Gateways (Ports)**: Interfaces que definem como o núcleo se comunica com sistemas externos.

### 2. Infrastructure (Infraestrutura)
Camada externa que contém:
- **Presentation**: Controllers REST que expõem a API.
- **Persistence**: Implementação do acesso a dados usando Spring Data JPA.
- **Gateway Implementations (Adapters)**: Implementações concretas das interfaces de gateway.
- **Configuration**: Configurações do Spring e da aplicação.

### Benefícios da Arquitetura Limpa
- **Testabilidade**: As regras de negócio podem ser testadas independentemente da infraestrutura.
- **Independência de Frameworks**: O núcleo da aplicação não depende de frameworks externos.
- **Independência de UI**: A interface do usuário pode ser alterada sem afetar a lógica de negócio.
- **Independência de Banco de Dados**: O banco de dados pode ser substituído sem afetar o núcleo da aplicação.

## Princípios SOLID

Este projeto aplica os princípios SOLID:

### 1. Single Responsibility Principle (SRP)
Cada classe tem uma única responsabilidade. Por exemplo:
- `ProductController`: Responsável apenas por lidar com requisições HTTP.
- `CreateProductCaseImpl`: Responsável apenas pela lógica de criação de produtos.
- `ProductRepositoryGateway`: Responsável apenas pelo acesso aos dados de produtos.

### 2. Open/Closed Principle (OCP)
As classes são abertas para extensão, mas fechadas para modificação. Por exemplo:
- Novas funcionalidades podem ser adicionadas criando novas implementações de interfaces existentes.

### 3. Liskov Substitution Principle (LSP)
As implementações de interfaces podem ser substituídas sem afetar o comportamento do programa. Por exemplo:
- Qualquer implementação de `ProductGateway` pode ser usada sem afetar o comportamento dos casos de uso.

### 4. Interface Segregation Principle (ISP)
Interfaces específicas são melhores que uma interface geral. Por exemplo:
- `CreateProductCase` e `FindProductsCase` são interfaces separadas em vez de uma única interface `ProductCase`.

### 5. Dependency Inversion Principle (DIP)
Módulos de alto nível não dependem de módulos de baixo nível. Ambos dependem de abstrações. Por exemplo:
- Os casos de uso dependem de interfaces `Gateway`, não de implementações concretas.
- A injeção de dependências é usada para fornecer implementações concretas.

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── dev/
│   │       └── phquartin/
│   │           └── storesalescleanapi/
│   │               ├── core/
│   │               │   ├── domain/          # Entidades de domínio
│   │               │   ├── enums/           # Enumerações
│   │               │   ├── gateway/         # Interfaces de gateway (ports)
│   │               │   └── usecases/        # Casos de uso
│   │               │       ├── category/    # Casos de uso para categorias
│   │               │       └── product/     # Casos de uso para produtos
│   │               └── infra/
│   │                   ├── configuration/   # Configurações
│   │                   ├── exception/       # Tratamento de exceções
│   │                   ├── gateway/         # Implementações de gateway
│   │                   ├── mapper/          # Mapeadores
│   │                   ├── persistence/     # Entidades e repositórios JPA
│   │                   └── presentation/    # Controllers, requests e responses
│   └── resources/
│       ├── application.properties          # Configurações da aplicação
│       └── db/
│           └── migration/                  # Migrações Flyway
└── test/                                   # Testes
```

## Como Executar

### Pré-requisitos
- Java 17+
- Docker e Docker Compose
- Maven

### Passos para Execução

1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/StoreSalesCleanApi.git
   cd StoreSalesCleanApi
   ```

2. Configure a variável de ambiente para a senha do MySQL:
   ```
   export MYSQL_ROOT_PASSWORD=sua_senha
   ```

3. Inicie o banco de dados MySQL:
   ```
   docker-compose up -d
   ```

4. Execute a aplicação:
   ```
   ./mvnw spring-boot:run
   ```

5. A API estará disponível em:
   ```
   http://localhost:8080
   ```

## Endpoints da API

### Produtos
- `GET /products` - Listar todos os produtos
- `POST /products` - Criar um novo produto

### Categorias
- `GET /categories` - Listar todas as categorias
- `POST /categories` - Criar uma nova categoria

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- MySQL
- Flyway Migration
- Docker
- Maven

## Melhorias em produção

- Entidade de Vendas
- Outros metodos Http como DELETE
- DockerFile