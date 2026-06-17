# 🎬 MovieFlix API

### 🚀 Backend profissional para gerenciamento de filmes

<p align="center">
  API REST desenvolvida com <strong>Java + Spring Boot</strong>, com autenticação JWT e documentação Swagger.
</p>

---

---

## 🚀 Tecnologias

<p align="center">
  <img src="https://img.shields.io/badge/Java-21+-red?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot"/>
  <img src="https://img.shields.io/badge/Security-JWT-blue?style=for-the-badge&logo=auth0"/>
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-brightgreen?style=for-the-badge&logo=swagger"/>
</p>

---

## 📌 Funcionalidades

* ✔ CRUD de filmes
* ✔ Gerenciamento de categorias
* ✔ Gerenciamento de streamings
* ✔ Autenticação com JWT
* ✔ Documentação com Swagger

---

## 📡 Endpoints principais

### 🎬 Filmes

```http
GET     /movieflix/movie
GET     /movieflix/movie/{id}
POST    /movieflix/movie
PUT     /movieflix/movie/{id}
DELETE  /movieflix/movie/{id}
GET     /movieflix/movie/search
```

### 🔐 Autenticação

```http
POST    /movieflix/auth/register
POST    /movieflix/auth/login
```

### 📚 Categoria

```http
GET     /movieflix/category
POST    /movieflix/category
GET     /movieflix/category/{id}
DELETE  /movieflix/category/{id}
```

### 📺 Streaming

```http
GET     /movieflix/streaming
POST    /movieflix/streaming
GET     /movieflix/streaming/{id}
DELETE  /movieflix/streaming/{id}
```

---

## 📖 Swagger

👉 http://localhost:8080/swagger-ui.html

---

## ▶️ Como executar

```bash
git clone https://github.com/marciosalesdev/movieflix.git
cd movieflix
mvn spring-boot:run
```

---

## 🔐 Autenticação JWT

Após login, utilize:

```http
Authorization: Bearer SEU_TOKEN
```

---

## 👨‍💻 Autor

**Marcio Serra Sales**
🔗 https://github.com/marciosalesdev

---

## ⭐ Destaque

Este projeto demonstra:

* APIs REST profissionais
* Segurança com JWT
* Boas práticas com Spring Boot
* Documentação com Swagger

---
