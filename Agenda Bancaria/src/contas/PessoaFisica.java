package contas;

public class PessoaFisica {

	public static void main(String[] args) {
		Conta cc1 = new Conta();
		cc1.clientes = ("Lele Ramos");
		cc1.saldo = 10000;
		System.out.println("Cliente: "+ cc1.clientes);
		cc1.exibirSaldo();
		cc1.despositar(5000);
		cc1.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		
		Conta cc2 = new Conta();
		cc2.clientes = ("Sirlene Sanches");
		cc2.saldo = 5000;
		System.out.println("Cliente: "+ cc2.clientes);
		cc2.exibirSaldo();
		cc2.sacar(2000);
		cc2.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		
		System.out.println("");
		System.out.println("Cliente: "+cc1.clientes);
		System.out.println("Favorecido: "+ cc2.clientes);
		
		cc1.transferir(cc2, 10000);
		cc2.exibirSaldo();
		System.out.println("Cliente: "+cc1.clientes);
		cc1.exibirSaldo();
		System.out.println("Cliente: "+cc2.clientes);
		cc2.exibirSaldo();
		System.out.println("");
		System.out.println("Relatório Grenciar");
		Conta gerente = new Conta();
		double total = gerente.soma(cc1.saldo,cc2.saldo);
		System.out.println("Saldo total: R$ "+ total);
		
	}

}
