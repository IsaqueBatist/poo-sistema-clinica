# 🏥 Sistema de Gerenciamento de Clínica (POO)

Repositório do primeiro trabalho da disciplina de Programação Orientada a Objetos (POO). O projeto foca na implementação de um sistema de gerenciamento de clínica a partir de um diagrama de classes pré-definido.

## 📜 Descrição do Projeto (Enunciado)

> "A partir da modelagem do diagrama faça a sua implementação na linguagem de programação Java."
<img width="716" height="409" alt="image" src="https://github.com/user-attachments/assets/7765598d-4314-4e0f-a428-0c0f1e69b3d5" />

## 👨‍💻 Integrantes do Grupo

* [Beatriz](https://github.com/bibiritriz)
* [Isaque](https://github.com/IsaqueBatist)
* [Victor](https://github.com/VictorLeonardo1346)

## 🏗️ Entregas

O projeto será dividido em três entregas principais:

### 1. Entrega 1: Models
* **O que é:** Criação de todas as classes que representam os dados do sistema.
* **Classes:** `Pessoa`, `Medico`, `Paciente`, `Consulta`, `Exame` e `Medicacao`.
* **Conceitos:** Herança (`Pessoa` como superclasse), Associações Binárias (ligações entre as classes), Encapsulamento (métodos `get` e `set`) e métodos de negócio (ex: `calcIMC()`, `calcValorTotalPagar()`).

### 2. Entrega 2: Views (Camada de Apresentação)
* **O que é:** Implementação das interfaces gráficas (telas) que permitirão ao usuário interagir com o sistema.
* **Tecnologia:** `javax.swing`.
* **Telas:** A definir.

### 3. Entrega 3: Controller e Persistênci
* **O que é:** A camada que faz a "ponte" entre as **Views** e os **Models**.
* **Função:** Validar os dados inseridos pelo usuário, executar as regras de negócio e coordenar a gravação e leitura dos dados.
* **Persistência:** Implementação da lógica para salvar os dados.

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem:** Java
* **IDE:** Netbeans
* **Bibliotecas Principais:**
    * `java.text.DecimalFormat`: Para formatar corretamente saídas numéricas, como valores monetários (R$) e o IMC.
    * `javax.swing`: Para a construção das **GUIs**.
* **Padrões e Conceitos:**
    * **POO:** Herança, Encapsulamento e Polimorfismo.
    * **Associações Binárias:** Implementação dos relacionamentos (1..1, 1..*, 0..*) definidos no diagrama de classes.
