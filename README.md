# 🚗 Sistema de Gestão de Estacionamento
Feito Por: Isaias Hitallo, Giovanny Morais , Leonardo Andrade

## 📖 Introdução

Este projeto é um **Sistema de Gestão de Estacionamento** desenvolvido em **Java com Spring Boot**, aplicando conceitos de **arquitetura MVC**, **persistência de dados com JPA/Hibernate** e **boas práticas de desenvolvimento**.

O sistema permite gerenciar usuários, veículos, vagas e registros de entrada e saída, simulando o funcionamento real de um estacionamento.

---

## 🧩 Modelo de Domínio

O modelo de domínio é composto pelas seguintes entidades:

- **Usuário**
  - Representa o proprietário de veículos.
  - Relacionamento: `1 Usuário → N Veículos`

- **Veículo**
  - Contém informações como placa, modelo e marca.
  - Relacionamentos:
    - `N Veículos → 1 Usuário`
    - `1 Veículo → N Registros de Acesso`

- **Vaga**
  - Representa uma vaga do estacionamento.
  - Possui status (DISPONÍVEL / OCUPADA).
  - Relacionamento: `1 Vaga → N Registros de Acesso`

- **RegistroAcesso**
  - Responsável por registrar a entrada e saída de veículos.
  - Relacionamentos:
    - `N Registros → 1 Veículo`
    - `N Registros → 1 Vaga`

O modelo foi implementado utilizando **JPA**, garantindo integridade referencial e facilidade de manutenção.

---

## 🛠️ CRUDs

O sistema implementa operações completas de **CRUD (Create, Read, Update, Delete)** para as seguintes entidades:

### ✔ Usuário
- Cadastro
- Listagem
- Edição
- Exclusão

### ✔ Veículo
- Cadastro vinculado a um usuário
- Listagem
- Edição
- Exclusão

### ✔ Vaga
- Cadastro
- Listagem
- Edição
- Exclusão
- Alteração de status (disponível / ocupada)

As operações seguem o padrão **MVC**, com separação clara entre Controller, Model e Repository.

---

## 🔗 Operação Mestre/Detalhe

O projeto utiliza o conceito de **mestre/detalhe**, onde uma entidade principal está relacionada a entidades dependentes.

### Exemplos:
- **Usuário → Veículos**
- **Veículo → Registros de Acesso**
- **Vaga → Registros de Acesso**

Esse padrão facilita a visualização de dados relacionados e mantém a consistência do sistema.

---

## 📊 Relatório

O sistema disponibiliza relatórios para acompanhamento do estacionamento, incluindo:

- Veículos atualmente estacionados
- Histórico de entradas e saídas
- Situação das vagas (disponíveis e ocupadas)
- Veículos cadastrados por usuário

Os relatórios são gerados a partir de consultas ao banco de dados e exibidos na interface do sistema.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database / MySQL
- Bootstrap 5

---

## ▶️ Como Executar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/LeonardoRibeiro-cpu/projetoFinal-mvc

# Acessar a pasta do projeto
cd seu-repositorio

# Executar o projeto
./mvnw spring-boot:run
