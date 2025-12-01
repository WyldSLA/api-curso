# 📚 API de Gerenciamento de Cursos

API RESTful desenvolvida com Spring Boot para gerenciamento completo de cursos, oferecendo operações CRUD e integração com banco de dados PostgreSQL.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.8**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **MapStruct 1.5.5**
- **SpringDoc OpenAPI (Swagger)**
- **Maven**

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- Java JDK 21 ou superior
- Maven 3.6+
- PostgreSQL 18

## 🔧 Configuração do Ambiente

### 1. Clone o repositório

```bash
git clone https://github.com/WyldSLA/api-curso.git
cd api-curso
```

### 2. Configure o Banco de Dados

Crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE curso_db;
```

### 3. Configure as credenciais

Edite o arquivo `src/main/resources/application.yml` com suas credenciais do PostgreSQL:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/curso_db
    username: seu_usuario
    password: sua_senha
```

### 4. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:3033/curso/`

## 🏗️ Estrutura do Projeto

```
api-curso/
├── src/
│   ├── main/
│   │   ├── java/com/wyldSLA/curso/
│   │   │   ├── controller/
│   │   │   │   └── CursoController.java          # Endpoints REST
│   │   │   ├── dto/
│   │   │   │   ├── CursoCreateDto.java           # DTO de entrada
│   │   │   │   └── CursoResponseDto.java         # DTO de resposta
│   │   │   ├── model/
│   │   │   │   └── CursoModel.java               # Entidade JPA
│   │   │   ├── enums/
│   │   │   │   └── CursoCategoria.java           # Enum de categorias
│   │   │   ├── repository/
│   │   │   │   └── CursoRepository.java          # Repositório JPA
│   │   │   ├── service/
│   │   │   │   ├── CursoService.java             # Interface do serviço
│   │   │   │   └── impl/
│   │   │   │       └── CursoServiceImpl.java     # Implementação
│   │   │   └── mapper/
│   │   │       └── CursoMapper.java              # MapStruct mapper
│   │   └── resources/
│   │       └── application.yml                   # Configurações
│   └── test/
├── pom.xml                                       # Dependências Maven
└── README.md                                     # Documentação
```

### Arquitetura em Camadas

A aplicação segue o padrão de arquitetura em camadas:

1. **Controller**: Recebe requisições HTTP e retorna respostas
2. **Service**: Contém a lógica de negócio
3. **Repository**: Gerencia o acesso aos dados
4. **Model**: Representa as entidades do banco de dados
5. **DTO**: Define os objetos de transferência de dados
6. **Mapper**: Converte entre entidades e DTOs

## 📡 Endpoints da API

### Base URL
```
http://localhost:3033/curso
```

### Operações Disponíveis

| Método | Endpoint | Descrição | Status Code |
|--------|----------|-----------|-------------|
| POST | `/curso` | Criar um novo curso | 201 Created |
| GET | `/curso` | Listar todos os cursos | 200 OK |
| GET | `/curso/{id}` | Buscar curso por ID | 200 OK |
| PUT | `/curso/{id}` | Atualizar curso existente | 200 OK |
| DELETE | `/curso/{id}` | Deletar um curso | 204 No Content |

---

### 📝 Detalhamento dos Endpoints

#### 1. Criar Curso

**Requisição:**
```http
POST /curso
Content-Type: application/json
```

**Body:**
```json
{
  "nome": "Java Spring Boot Avançado",
  "descricao": "Curso completo de desenvolvimento com Spring Boot",
  "cargaHoraria": 80,
  "cursoCategoria": "SUPERIOR"
}
```

**Resposta de Sucesso (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "nome": "Java Spring Boot Avançado",
  "descricao": "Curso completo de desenvolvimento com Spring Boot",
  "cargaHoraria": 80,
  "cursoCategoria": "SUPERIOR"
}
```

**Categorias disponíveis:**
- `FUNDAMENTAL` - Cursos de ensino fundamental
- `MEDIO` - Cursos de ensino médio
- `SUPERIOR` - Cursos de ensino superior/universitário

**Validações:**
- `nome`: obrigatório, não pode estar vazio
- `cargaHoraria`: obrigatório, deve ser número positivo
- `descricao`: obrigatório, não pode estar vazio
- `cursoCategoria`: obrigatório, deve ser uma das categorias válidas

---

#### 2. Listar Todos os Cursos

**Requisição:**
```http
GET /curso
```

**Resposta de Sucesso (200 OK):**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "nome": "Java Spring Boot Avançado",
    "descricao": "Curso completo de desenvolvimento com Spring Boot",
    "cargaHoraria": 80,
    "cursoCategoria": "SUPERIOR"
  },
  {
    "id": "660e8400-e29b-41d4-a716-446655440001",
    "nome": "Matemática Básica",
    "descricao": "Fundamentos de matemática",
    "cargaHoraria": 40,
    "cursoCategoria": "FUNDAMENTAL"
  }
]
```

---

#### 3. Buscar Curso por ID

**Requisição:**
```http
GET /curso/{id}
```

**Exemplo:**
```http
GET /curso/550e8400-e29b-41d4-a716-446655440000
```

**Resposta de Sucesso (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "nome": "Java Spring Boot Avançado",
  "descricao": "Curso completo de desenvolvimento com Spring Boot",
  "cargaHoraria": 80,
  "cursoCategoria": "SUPERIOR"
}
```

**Resposta de Erro (404 Not Found):**
```json
{
  "message": "Curso não encontrado"
}
```

---

#### 4. Atualizar Curso

**Requisição:**
```http
PUT /curso/{id}
Content-Type: application/json
```

**Exemplo:**
```http
PUT /curso/550e8400-e29b-41d4-a716-446655440000
```

**Body:**
```json
{
  "nome": "Matemática Avançada",
  "descricao": "Curso de matemática para ensino médio",
  "cargaHoraria": 120,
  "cursoCategoria": "MEDIO"
}
```

**Resposta de Sucesso (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "nome": "Matemática Avançada",
  "descricao": "Curso de matemática para ensino médio",
  "cargaHoraria": 120,
  "cursoCategoria": "MEDIO"
}
```

**Observações:**
- Todos os campos devem ser enviados, mesmo que não tenham sido alterados
- As mesmas validações do endpoint de criação se aplicam

---

#### 5. Deletar Curso

**Requisição:**
```http
DELETE /curso/{id}
```

**Exemplo:**
```http
DELETE /curso/550e8400-e29b-41d4-a716-446655440000
```

**Resposta de Sucesso (204 No Content):**
```
(Sem corpo na resposta)
```

---


## 📖 Documentação da API (Swagger)

Acesse a documentação interativa da API através do Swagger UI para testar os endpoints diretamente no navegador:

**Swagger UI:**
```
http://localhost:3033/curso/swagger-ui.html
```

**OpenAPI JSON:**
```
http://localhost:3033/curso/v3/api-docs
```

O Swagger UI oferece:
- Interface interativa para testar todos os endpoints
- Documentação automática de todos os DTOs e modelos
- Exemplos de requisições e respostas
- Validações e constraints de cada campo

---

## 🏗️ Estrutura do Projeto

```
api-curso/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/wyldSLA/curso/
│   │   │       ├── controller/
│   │   │       │   └── CursoController.java
│   │   │       ├── dto/
│   │   │       │   ├── CursoCreateDto.java
│   │   │       │   └── CursoResponseDto.java
│   │   │       ├── model/
│   │   │       │   └── CursoModel.java
│   │   │       ├── enums/
│   │   │       │   └── CursoCategoria.java
│   │   │       ├── repository/
│   │   │       │   └── CursoRepository.java
│   │   │       ├── service/
│   │   │       │   ├── CursoService.java
│   │   │       │   └── impl/
│   │   │       │       └── CursoServiceImpl.java
│   │   │       └── mapper/
│   │   │           └── CursoMapper.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
├── pom.xml
└── README.md
```

## 🛠️ Funcionalidades

- ✅ CRUD completo de cursos
- ✅ Validação de dados com Bean Validation
- ✅ Categorização de cursos (Fundamental, Médio, Superior)
- ✅ Persistência com JPA/Hibernate
- ✅ Mapeamento de objetos com MapStruct
- ✅ Documentação automática com OpenAPI/Swagger
- ✅ IDs únicos com UUID
- ✅ Logs SQL formatados
- ✅ Hot reload com DevTools

## 📊 Modelo de Dados

### Entidade Curso

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | UUID | Identificador único do curso |
| nome | String | Nome do curso (obrigatório) |
| cargaHoraria | Integer | Carga horária em horas (obrigatório, positivo) |
| descricao | Text | Descrição detalhada do curso (obrigatório) |
| cursoCategoria | Enum | Categoria do curso: FUNDAMENTAL, MEDIO ou SUPERIOR |

### Validações

- **nome**: Não pode estar vazio
- **cargaHoraria**: Campo obrigatório, deve ser um número positivo
- **descricao**: Não pode estar vazia
- **cursoCategoria**: Campo obrigatório, deve ser uma das categorias válidas

## 🔒 Configurações de Segurança

> ⚠️ **Atenção**: Por padrão, esta API não possui autenticação/autorização implementada. Para ambientes de produção, recomenda-se implementar Spring Security com JWT ou OAuth2.

## 🧪 Testes

Execute os testes com:

```bash
mvn test
```

## 📦 Build para Produção

Para gerar o arquivo JAR executável:

```bash
mvn clean package
```

O arquivo será gerado em: `target/curso-0.0.1-SNAPSHOT.jar`

Para executar:

```bash
java -jar target/curso-0.0.1-SNAPSHOT.jar
```

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

**WyldSLA**

- GitHub: [@WyldSLA](https://github.com/WyldSLA)

## 📞 Suporte

Para reportar bugs ou solicitar novas funcionalidades, abra uma [issue](https://github.com/WyldSLA/api-curso/issues).

---

⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!
