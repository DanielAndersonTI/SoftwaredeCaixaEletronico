package com.softwareCaixaEletronico;

// Define a interface ServicoRemoto, que abstrai operações relacionadas à conta bancária.
public interface ServicoRemoto {

	// Método para recuperar os dados de uma conta com base no número da conta.
	ContaCorrente recuperarConta(String numeroConta);

	// Método para persistir os dados atualizados de uma conta no serviço remoto.
	void persistirConta(ContaCorrente conta);

	// Método redundante (possivelmente adicionado por engano) para persistir os
	// dados de uma conta.
	// Deve ser revisado e removido se não houver propósito claro.
	void persistirConta1(ContaCorrente conta);
}
