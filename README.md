# driven-entrega2-aceleracao-java

- Entrega #02 - API Tweteroo com Spring do aluno Luiz Cláudio F. Fernandez, Aceleração de Orientação a Objetos (01/2024) com Java da Driven.

## Descrição

- Seu primeiro projeto Spring será a construção da API do conhecido Tweteroo, um clone do Twitter X, que foi implementado no módulo de back-end da formação.

## Requisitos

### Geral

- A porta utilizada pelo seu servidor deve ser a 8080 (Porta padrão do Spring)

- Versionamento usando Git é obrigatório, crie um **repositório público** no seu perfil do GitHub

- Faça commits a cada funcionalidade implementada e coloque mensagens semânticas neles

### Armazenamento de dados

- Para persistir os dados (usuários e tweets), utilize um banco de dados.

- O formato de um **usuário** deve possuir:
  - `id` ⇒ numérico, gerado automaticamente
  - `avatar` ⇒ String, é uma url de imagem, não pode ser nulo
  - `username` ⇒ String de tamanho máximo 100, não pode ser nulo

- O formato de um **tweet** deve possuir:

  - `id` ⇒ numérico, gerado automaticamente
  - `text` ⇒ String de tamanho máximo 280, não pode ser nulo

- Um tweet é criado por um único usuário e um usuário pode ter múltiplos tweets.

### **POST** `/users`

- Deve receber (pelo `body` da request) um parâmetro `username` e um `avatar`, contendo o username do usuário e a sua foto de avatar:
    
  ```jsx
  {
      username: "bobesponja",
      avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ```
    
- Por fim, retornar a mensagem o `status 201 (CREATED)` com o objeto que foi criado
    
  ```jsx
  {
      id: 1,
      username: "bobesponja",
      avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ```
    
- Não pode criar um usuário com username repetido. Nesse caso, retorna status `409 (CONFLICT)`.

### **POST** `/tweets`

- Deve receber (pelo body da request), os parâmetros `text` e `userId`:
    
  ```jsx
  {
    userId: 1,
    text: "eu amo hamburguer de siri"
  }
  ```
    
- Salvar esse tweet na tabela de tweets

- Por fim, retornar o status `201 (CREATED)` com o objeto contendo as informações do tweet e do usuário:
    
  ```java
  {
    "id": 20,
    "text": "eu amo hamburguer de siri",
    "user": {
      "id": 1,
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
    }
  }
  ```
        
### **GET** `/tweets`

- Retornar todos os tweets publicados com o status `200 (OK)`.
    
  ```jsx
  [
    {
      "id": 20,
      "text": "meu primeiro tweet",
      "user": {
        "id": 1,
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
      }
    },
    {
      "id": 21,
      "text": "eu moro numa pedra",
      "user": {
        "id": 2,
        "username": "patrick",
        "avatar": "https://gartic.com.br/imgs/mural/te/tettyzinhah15/patrick-estrela.png"
      }
    },
    {
      "id": 22,
      "text": "eu amo hambúrguer de siri",
      "user": {
        "id": 1,
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
      }
    }
  ]
  ```
        
### **GET** `/tweets/user/:userId`

- Retornar todos os tweets publicados do usuário recebido por parâmetro de rota com o status `200 (OK)`.
    
  ```jsx
  [
    {
      "id": 20,
      "text": "meu primeiro tweet",
      "user": {
        "id": 1,
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
      }
    },
    {
      "id": 22,
      "text": "eu amo hambúrguer de siri",
      "user": {
        "id": 1,
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
      }
    }
  ]
  ```