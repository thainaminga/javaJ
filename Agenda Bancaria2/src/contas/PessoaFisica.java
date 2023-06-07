package contas;

public class PessoaFisica {

	public static void main(String[] args) {
		Conta cc1 = new Conta();
		cc1.setClientes("Lele Ramos");
		cc1.setSaldo(10000);
		System.out.println("Cliente: "+ cc1.getClientes());
		cc1.exibirSaldo();
		cc1.despositar(5000);
		cc1.exibirSaldo();
		cc1.sacar(1000);
		cc1.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		
		Conta cc2 = new Conta();
		cc2.setClientes("Sirlene Sanches");
		cc2.setSaldo(5000);
		System.out.println("Cliente: "+ cc2.getClientes());
		cc2.exibirSaldo();
		cc2.sacar(1000);
		cc2.exibirSaldo();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Cliente: "+cc1.getClientes());
		System.out.println("Favorecido: "+ cc2.getClientes());
		cc1.transferir(cc2, 1000);
		cc2.exibirSaldo();
		System.out.println("Cliente: "+cc1.getClientes());
		cc1.exibirSaldo();
		System.out.println("Cliente: "+cc2.getClientes());
		cc2.exibirSaldo();
		System.out.println("");
		System.out.println("Relatório Grenciar");
		Conta gerente = new Conta();
		double total = gerente.soma(cc1.getSaldo(),cc2.getSaldo());
		System.out.println("Saldo total: R$ "+ total);
		
	}

}
