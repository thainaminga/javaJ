package seguros;

import contas.Conta;

public class SeguroPessoaFisica extends Conta {

	public static void main(String[] args) {
		SeguroPessoaFisica cc3 = new SeguroPessoaFisica();
		cc3.setClientes("Robson Vaamonde");
		cc3.setSaldo(30000);
		System.out.println("Cliente: "+ cc3.getClientes());
		cc3.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		
	}

}
