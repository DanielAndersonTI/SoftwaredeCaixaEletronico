package com.testeSoftwareCaixaEletronico;

import static org.junit.jupiter.api.Assertions.*; // Importa métodos de asserções para os testes.
import org.junit.jupiter.api.BeforeEach; // Configuração antes de cada teste.
import org.junit.jupiter.api.Test; // Anotação para os métodos de teste.

import com.softwareCaixaEletronico.CaixaEletronico; // Classe principal que será testada.

// Classe de teste para o CaixaEletronico.
class TesteSoftwareCaixaEletronico {

	private CaixaEletronico caixa; // Instância do CaixaEletronico.
	private MockServicoRemoto mockServicoRemoto; // Mock do serviço remoto.
	private MockHardware mockHardware; // Mock do hardware.

	@BeforeEach
	void setUp() {
		// Inicializa os mocks e a classe a ser testada.
		mockServicoRemoto = new MockServicoRemoto();
		mockHardware = new MockHardware();
		caixa = new CaixaEletronico(mockServicoRemoto, mockHardware);
	}

	@Test
	void testLogarComSucesso() {
		// Verifica autenticação bem-sucedida com senha válida.
		assertEquals("Usuário Autenticado", caixa.logar("senha123"));
	}

	@Test
	void testLogarComFalha() {
		// Verifica autenticação falha com senha inválida.
		assertEquals("Não foi possível autenticar o usuário", caixa.logar("senhaErrada"));
	}

	@Test
	void testSaldo() {
		// Após login, verifica se o saldo é exibido corretamente.
		caixa.logar("senha123");
		assertEquals("O saldo é R$1000,00", caixa.saldo());
	}

	@Test
	void testSacarComSucesso() {
		// Após login, verifica saque bem-sucedido e atualização do saldo.
		caixa.logar("senha123");
		assertEquals("Retire seu dinheiro", caixa.sacar(500.00));
		assertEquals("O saldo é R$500,00", caixa.saldo());
	}

	@Test
	void testSacarSaldoInsuficiente() {
		// Após login, verifica mensagem de saldo insuficiente para saque maior que o
		// saldo.
		caixa.logar("senha123");
		assertEquals("Saldo insuficiente", caixa.sacar(1500.00));
	}

	@Test
	void testDepositarComSucesso() {
		// Após login, verifica depósito bem-sucedido e atualização do saldo.
		caixa.logar("senha123");
		assertEquals("Depósito recebido com sucesso", caixa.depositar(500.00));
		assertEquals("O saldo é R$1500,00", caixa.saldo());
	}
}
