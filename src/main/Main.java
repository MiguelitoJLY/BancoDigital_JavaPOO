package main;

import javax.swing.JOptionPane;

import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Main {
	
	public static void main(String[] args) {
		int resultado = 0;
		
		JOptionPane.showMessageDialog(null, "Seja bem-vindo ao nosso Banco Digital da DIO!");
		
		String nome = JOptionPane.showInputDialog("Por favor, digite o seu nome:");
		String agencia = JOptionPane.showInputDialog("Por favor, digite o número da agência da sua conta bancária:");
		String numeroConta = JOptionPane.showInputDialog("Por favor, digite o número da sua conta bancária:");
		
		
		ContaCorrente contaCorrente = new ContaCorrente(nome, Integer.parseInt(agencia), Integer.parseInt(numeroConta), 0.0);
		ContaCorrente contaCorrenteFulano = new ContaCorrente(nome, Integer.parseInt(agencia), Integer.parseInt(numeroConta), 0.0);
		ContaPoupanca contaPoupanca = new ContaPoupanca(nome, Integer.parseInt(agencia), Integer.parseInt(numeroConta), 0.0);
		
		JOptionPane.showMessageDialog(null, "Seja muito bem-vindo " + nome + "!");
		
		do {
			String escolha = JOptionPane.showInputDialog("Você deseja sacar (digite 's'), depositar (digite 'd') ou transferir (digite 't')?");
					
					if(escolha.equalsIgnoreCase("d")) {
						String escolhaDeposito = JOptionPane.showInputDialog("Você deseja depositar na sua conta corrente (digite 'cc') ou na sua conta poupança (digite 'cp')?");
						
						switch(escolhaDeposito) {
						case "cc":
							String valorCorrente = JOptionPane.showInputDialog("Quanto você quer depositar?");
							contaCorrente.depositar(Double.parseDouble(valorCorrente));
							contaCorrente.extratoCorrente();
							JOptionPane.showMessageDialog(null, "Valor depositado!");
							break;
							
						case "cp":
							String valorPoupanca = JOptionPane.showInputDialog("Quanto você quer depositar?");
							contaPoupanca.depositar(Double.parseDouble(valorPoupanca));
							contaCorrente.sacar(Double.parseDouble(valorPoupanca));
							contaPoupanca.extratoPoupanca();
							contaCorrente.extratoCorrente();
							JOptionPane.showMessageDialog(null, "Valor depositado!");
							break;
							
						default:
							JOptionPane.showMessageDialog(null, "Essa opção não existe. Operação cancelada.");
							break;
						}
						
						
					} else if(escolha.equalsIgnoreCase("s")) {
						
						String escolhaSaque = JOptionPane.showInputDialog("Você deseja sacar da sua conta corrente (digite 'cc') ou da sua conta poupança (digite 'cp')?");
						
						switch(escolhaSaque) {
						case "cc":
							String valorCorrente = JOptionPane.showInputDialog("Quanto você deseja sacar?");
							if (Double.parseDouble(valorCorrente) > contaCorrente.getSaldo()) {
								JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para sacar este valor.");
							} else {
								contaCorrente.sacar(Double.parseDouble(valorCorrente));
								contaCorrente.extratoCorrente();
								JOptionPane.showMessageDialog(null, "Valor sacado!");
							}
							break;
						
						case "cp":
							String valorPoupanca = JOptionPane.showInputDialog("Quanto você deseja sacar?");
							if (Double.parseDouble(valorPoupanca) > contaPoupanca.getSaldo()) {
								JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para sacar este valor.");
							} else {
								contaPoupanca.sacar(Double.parseDouble(valorPoupanca));
								contaCorrente.depositar(Double.parseDouble(valorPoupanca));
								contaPoupanca.extratoPoupanca();
								contaCorrente.extratoCorrente();
								JOptionPane.showMessageDialog(null, "Valor sacado!");
							}
							break;
						
						default:
							JOptionPane.showMessageDialog(null, "Essa opção não existe. Operação cancelada.");
							break;
						}
					} else if(escolha.equalsIgnoreCase("t")) {
						
						JOptionPane.showMessageDialog(null, "Você só pode transferir através da sua conta corrente!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
						
						JOptionPane.showInputDialog("Para quem você deseja transferir?");
						String valorTransferencia = JOptionPane.showInputDialog("Quanto você deseja transferir?");
						
						if (Double.parseDouble(valorTransferencia) > contaCorrente.getSaldo()) {
							JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para transferir esse valor.");
						} else {
							contaCorrente.transferir(Double.parseDouble(valorTransferencia), contaCorrenteFulano);
							contaCorrente.extratoCorrente();
							JOptionPane.showMessageDialog(null, "Valor transferido!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Essa opção não existe em nosso Banco Digital.");
					}
					
					resultado = JOptionPane.showConfirmDialog(null, "Deseja realizar mais alguma operação?");
		} while(resultado == 0);
		
	}

}
