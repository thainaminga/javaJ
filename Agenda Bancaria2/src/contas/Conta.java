package contas;

public class Conta {
	//atributos
	private String clientes; 
	private double saldo;
	
	
	public String getClientes() {
		return clientes;
	}

	public void setClientes(String clientes) {
		this.clientes = clientes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//------------------------ Encapsulamento
	
	//construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}
	
	//metodos
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}
	/**
	 * metodo com paramentro(variavel)
	 * @param valor
	 */
	 void despositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ "+ valor);
		
	}
	 void sacar(double valor) {
		saldo -= valor;
		System.out.println("Dédito: R$ "+ valor);
		
	}
	/**
	 * metodo com dois parametros(objeto e variavel)
	 * @param destino
	 * @param valor
	 */
	void transferir(Conta destino,double valor) {
		this.sacar(valor);
		destino.despositar(valor);
		System.out.println("Transferêcia: R$ " +valor);
	}
	/**
	 * metodo co dois parametros (variavel)
	 * @param cc1
	 * @param cc2
	 * @return
	 */
	double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		
		
		return total;
		
	}
}
