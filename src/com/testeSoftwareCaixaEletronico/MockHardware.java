package com.testeSoftwareCaixaEletronico;

import com.softwareCaixaEletronico.Hardware;
import com.softwareCaixaEletronico.HardwareException;

// Classe MockHardware que implementa a interface Hardware para simular interações com hardware.
public class MockHardware implements Hardware {

	// Simula a obtenção do número da conta a partir do cartão.
	@Override
	public String pegarNumeroDaContaCartao() throws HardwareException {
		// Retorna um número de conta fictício para testes.
		return "12345";
	}

	// Simula a entrega de dinheiro pelo hardware.
	@Override
	public void entregarDinheiro() throws HardwareException {
		// Mock vazio representando o comportamento do hardware durante a entrega de
		// dinheiro.
	}

	// Simula a leitura de um envelope de depósito pelo hardware.
	@Override
	public void lerEnvelope() throws HardwareException {
		// Mock vazio representando o comportamento do hardware ao ler o envelope.
	}
}
