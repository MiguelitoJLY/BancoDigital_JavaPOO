package conta.contaPrincipal;

import conta.contaInterface.AcoesCliente;

public class Conta implements AcoesCliente {
	
	protected String nomeCliente;
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	
	public Conta(String nomeCliente, int agencia, int numeroConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public int getAgencia() {
		return agencia;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	@Override
	public void transferir(double valor, Conta contaDestino) {
		sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public void imprimirExtrato() {
		System.out.println("Nome do cliente: " + this.nomeCliente);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Numero da conta: " + this.numeroConta);
		System.out.println("Saldo atual: " + this.saldo);
	}

}
