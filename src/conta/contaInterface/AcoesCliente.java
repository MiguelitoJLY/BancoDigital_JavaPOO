package conta.contaInterface;

import conta.contaPrincipal.Conta;

public interface AcoesCliente {
	
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, Conta contaDestino);

}
