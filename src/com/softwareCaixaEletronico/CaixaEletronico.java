package com.softwareCaixaEletronico;

import com.testeSoftwareCaixaEletronico.MockHardware;
import com.testeSoftwareCaixaEletronico.MockServicoRemoto;

// Classe principal que implementa as funcionalidades do Caixa Eletrônico.
public class CaixaEletronico {

	// Interfaces para interagir com o serviço remoto e hardware, permitindo mocks.
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private ContaCorrente contaLogada; // Armazena a conta autenticada.

	// Construtor que aceita mocks para facilitar testes.
	public CaixaEletronico(MockServicoRemoto mockServicoRemoto, MockHardware mockHardware) {
		this.servicoRemoto = (ServicoRemoto) mockServicoRemoto;
		this.hardware = (Hardware) mockHardware;
	}

	// Método para autenticar o usuário usando senha e número da conta do cartão.
	public String logar(String senha) {
		try {
			// Obtém o número da conta do cartão através do hardware.
			String numeroConta = hardware.pegarNumeroDaContaCartao();
			// Recupera os dados da conta a partir do serviço remoto.
			ContaCorrente conta = servicoRemoto.recuperarConta(numeroConta);

			// Verifica se a conta existe e a senha está correta.
			if (conta != null && conta.getSenha().equals(senha)) {
				contaLogada = conta; // Define a conta como autenticada.
				return "Usuário Autenticado";
			}
		} catch (HardwareException e) {
			// Retorna mensagem de erro caso o hardware apresente falha.
			return "Erro ao acessar hardware: " + e.getMessage();
		}
		return "Não foi possível autenticar o usuário"; // Autenticação falhou.
	}

	// Retorna o saldo da conta autenticada.
	public String saldo() {
		if (contaLogada != null) {
			// Formata o saldo da conta em um formato amigável.
			return String.format("O saldo é R$%.2f", contaLogada.getSaldo());
		}
		return "Usuário não autenticado"; // Impede acesso ao saldo sem login.
	}

	// Realiza o saque de um valor específico.
	public String sacar(double valor) {
		if (contaLogada == null)
			return "Usuário não autenticado"; // Exige autenticação.

		// Verifica se há saldo suficiente para realizar o saque.
		if (valor > contaLogada.getSaldo()) {
			return "Saldo insuficiente";
		}
		try {
			hardware.entregarDinheiro(); // Solicita ao hardware a liberação do dinheiro.
			// Atualiza o saldo da conta após o saque.
			contaLogada.setSaldo(contaLogada.getSaldo() - valor);
			// Persiste a conta com o saldo atualizado no serviço remoto.
			servicoRemoto.persistirConta(contaLogada);
			return "Retire seu dinheiro";
		} catch (HardwareException e) {
			// Retorna erro caso o hardware apresente falha.
			return "Erro ao acessar hardware: " + e.getMessage();
		}
	}

	// Realiza o depósito de um valor específico.
	public String depositar(double valor) {
		if (contaLogada == null)
			return "Usuário não autenticado"; // Exige autenticação.

		try {
			hardware.lerEnvelope(); // Solicita ao hardware a leitura do envelope.
			// Atualiza o saldo da conta após o depósito.
			contaLogada.setSaldo(contaLogada.getSaldo() + valor);
			// Persiste a conta com o saldo atualizado no serviço remoto.
			servicoRemoto.persistirConta(contaLogada);
			return "Depósito recebido com sucesso";
		} catch (HardwareException e) {
			// Retorna erro caso o hardware apresente falha.
			return "Erro ao acessar hardware: " + e.getMessage();
		}
	}
}
