# 🏥 Sistema de Gerenciamento de Clínica (POO)

Repositório do primeiro trabalho da disciplina de Programação Orientada a Objetos (POO). O projeto foca na implementação de um sistema de gerenciamento de clínica a partir de um diagrama de classes pré-definido.

## 📜 Descrição do Projeto (Enunciado)

> "A partir da modelagem do diagrama faça a sua implementação na linguagem de programação Java."
<img width="716" height="409" alt="image" src="https://github.com/user-attachments/assets/7765598d-4314-4e0f-a428-0c0f1e69b3d5" />

> "De acordo com as definições do modelo D.E.R, abaixo, faça a impelementação das tabelas tbMedico, tbPaciente, tbConsulta, tbMedicacao, tbExame."
<img width="716" height="409" alt="image" src="https://github.com/user-attachments/assets/92c16d43-07c9-4a9a-a166-067b896b515a" />

> "A partir das GUIs faça a sua implementação utilizando JFrames"
   * **1. GUI Menu**
     
        <img width="631" height="265" alt="image" src="https://github.com/user-attachments/assets/7257beac-6d26-419c-8eb1-00c47b4a3b41" />
   * **2. GUI Cadastro Medico**
     
        <img width="411" height="255" alt="image" src="https://github.com/user-attachments/assets/a3a2ee6d-5dcc-4a5e-a2d7-e9615e2b0b8a" />
   * **3. GUI Cadastro Paciente**
     
        <img width="409" height="318" alt="image" src="https://github.com/user-attachments/assets/b5413500-b845-477b-9148-9cc580c43989" />
   * **4. GUI Marcar Consulta**

        <img width="519" height="261" alt="image" src="https://github.com/user-attachments/assets/59fa0fee-8543-4863-8dda-fed9018b01ec" />
   * **5. GUI Prescrever Medicação**
   
        <img width="508" height="283" alt="image" src="https://github.com/user-attachments/assets/665ddcc9-f95e-46cc-b247-c06305341dc2" />
   * **6. GUI Marcar Exame**

        <img width="517" height="352" alt="image" src="https://github.com/user-attachments/assets/4905ca95-3d29-4b75-93fc-51fcefe051f7" />


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
