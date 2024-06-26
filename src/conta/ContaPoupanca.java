package conta;

import conta.contaPrincipal.Conta;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(String nomeCliente, int agencia, int numeroConta, double saldo) {
		super(nomeCliente, agencia, numeroConta, saldo);
	}

	public void extratoPoupanca() {
		System.out.println("----- Extrato da Poupança -----");
		System.out.println("");
		imprimirExtrato();
	}

}
