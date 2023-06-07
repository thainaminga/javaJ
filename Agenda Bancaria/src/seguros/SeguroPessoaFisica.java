package seguros;

import contas.Conta;

public class SeguroPessoaFisica {

	public static void main(String[] args) {
		Conta cc3 = new Conta();
		cc3.clientes = ("Robson Vaamonde");
		cc3.saldo = 5000;
		System.out.println("Cliente: "+ cc3.clientes);
		cc3.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		
	}

}
