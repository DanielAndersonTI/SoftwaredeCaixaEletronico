# Software de Caixa Eletrônico

Este projeto simula o funcionamento de um **Caixa Eletrônico** utilizando o conceito de **Test-Driven Development (TDD)** com **Mocks** para testar as funcionalidades. O objetivo é demonstrar como implementar testes unitários, simulação de hardware e interações com o serviço remoto para operações como login, saldo, saque e depósito em uma conta bancária.

## Funcionalidades

- **Login**: Autentica o usuário com base no número da conta e senha.
- **Consulta de saldo**: Exibe o saldo da conta logada.
- **Saque**: Permite que o usuário realize saques, desde que haja saldo suficiente.
- **Depósito**: Permite que o usuário faça um depósito, aumentando o saldo da conta.
- **Simulação de hardware**: Utiliza mocks para simular interações com o hardware, como leitura de cartão, entrega de dinheiro e leitura de envelope.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal para o desenvolvimento do sistema.
- **JUnit**: Framework de testes para implementar os testes unitários.
- **Mockito**: Biblioteca para criação de mocks durante os testes.
- **Eclipse**: IDE utilizada para o desenvolvimento.
- **Git**: Controle de versão para gerenciar o código-fonte.

## Estrutura do Projeto

- **CaixaEletronico.java**: Classe principal que simula as operações do caixa eletrônico (login, saldo, saque, depósito).
- **ServicoRemoto.java**: Interface que define os métodos para interação com o serviço remoto (recuperação e persistência da conta).
- **Hardware.java**: Interface para interação com o hardware (leitura de cartão, entrega de dinheiro, etc).
- **ContaCorrente.java**: Representação da conta bancária do usuário.
- **MockServicoRemoto.java**: Implementação mockada do serviço remoto para simular a recuperação e persistência das contas.
- **MockHardware.java**: Implementação mockada do hardware para simular operações como leitura de cartão e entrega de dinheiro.
- **HardwareException.java**: Exceção personalizada para erros relacionados ao hardware.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/DanielAndersonTI/software-caixa-eletronico.git
