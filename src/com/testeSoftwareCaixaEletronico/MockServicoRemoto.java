package com.testeSoftwareCaixaEletronico;

import java.util.HashMap;
import java.util.Map;
import com.softwareCaixaEletronico.ContaCorrente;
import com.softwareCaixaEletronico.ServicoRemoto;

// Classe MockServicoRemoto que implementa a interface ServicoRemoto para simular operações em um serviço remoto.
public class MockServicoRemoto implements ServicoRemoto {

	// Mapa para simular o armazenamento de contas correntes, usando o número da
	// conta como chave.
	private Map<String, ContaCorrente> contas = new HashMap<>();

	// Construtor inicializa o mock com uma conta fictícia para testes.
	public MockServicoRemoto() {
		// Adiciona uma conta de exemplo ao mapa, com número da conta, senha e saldo
		// inicial.
		contas.put("12345", new ContaCorrente("12345", "senha123", 1000.00));
	}

	// Implementação do método recuperarConta, que busca uma conta pelo número.
	@Override
	public ContaCorrente recuperarConta(String numeroConta) {
		// Retorna a conta correspondente ao número fornecido ou null se não encontrada.
		return contas.get(numeroConta);
	}

	// Implementação do método persistirConta, que atualiza ou adiciona uma conta ao
	// mock.
	@Override
	public void persistirConta(ContaCorrente conta) {
		// Adiciona ou substitui a conta no mapa com base no número da conta.
		contas.put(conta.getNumeroConta(), conta);
	}

	// Método adicional persistirConta1, que realiza a mesma função do método
	// persistirConta.
	public void persistirConta1(ContaCorrente conta) {
		// Adiciona ou substitui a conta no mapa com base no número da conta.
		contas.put(conta.getNumeroConta(), conta);
	}
}
