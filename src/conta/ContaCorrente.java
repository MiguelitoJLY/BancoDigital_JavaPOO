package conta;

import conta.contaPrincipal.Conta;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(String nomeCliente, int agencia, int numeroConta, double saldo) {
		super(nomeCliente, agencia, numeroConta, saldo);
	}

	public void extratoCorrente() {
		System.out.println("----- Extrato da Conta Corrente -----");
		System.out.println("");
		imprimirExtrato();
	}

}
