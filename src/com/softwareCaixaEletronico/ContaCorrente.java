package com.softwareCaixaEletronico;

// Classe que representa uma conta corrente, contendo informações como número da conta, senha e saldo.
public class ContaCorrente {
	// Atributos privados para proteger os dados da conta.
	private String numeroConta; // Número identificador único da conta.
	private String senha; // Senha de acesso à conta.
	private double saldo; // Saldo disponível na conta.

	// Construtor para inicializar uma nova instância de ContaCorrente.
	public ContaCorrente(String numeroConta, String senha, double saldo) {
		this.numeroConta = numeroConta; // Inicializa o número da conta.
		this.senha = senha; // Inicializa a senha da conta.
		this.saldo = saldo; // Inicializa o saldo da conta.
	}

	// Método getter para obter o número da conta.
	public String getNumeroConta() {
		return numeroConta;
	}

	// Método getter para obter a senha da conta.
	public String getSenha() {
		return senha;
	}

	// Método getter para obter o saldo da conta.
	public double getSaldo() {
		return saldo;
	}

	// Método setter para atualizar o saldo da conta.
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
