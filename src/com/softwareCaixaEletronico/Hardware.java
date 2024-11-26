package com.softwareCaixaEletronico;

// Interface que define os métodos para interação com o hardware do caixa eletrônico.
public interface Hardware {

	/**
	 * Recupera o número da conta associado ao cartão inserido.
	 * 
	 * @return O número da conta como uma String.
	 * @throws HardwareException Caso ocorra um erro ao acessar o hardware.
	 */
	String pegarNumeroDaContaCartao() throws HardwareException;

	/**
	 * Simula a entrega do dinheiro solicitado ao usuário.
	 * 
	 * @throws HardwareException Caso ocorra um erro ao acessar o hardware.
	 */
	void entregarDinheiro() throws HardwareException;

	/**
	 * Simula a leitura de um envelope de depósito inserido pelo usuário.
	 * 
	 * @throws HardwareException Caso ocorra um erro ao acessar o hardware.
	 */
	void lerEnvelope() throws HardwareException;
}
