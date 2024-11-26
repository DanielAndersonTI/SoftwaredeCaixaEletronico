package com.softwareCaixaEletronico;

// Classe que representa uma exceção específica para erros de hardware no caixa eletrônico.
public class HardwareException extends Exception {

	// Construtor da classe que recebe a mensagem de erro e a passa para a classe
	// pai (Exception).
	public HardwareException(String message) {
		super(message); // Chama o construtor da classe Exception para configurar a mensagem de erro.
	}
}
