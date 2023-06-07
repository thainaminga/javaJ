package contas;

public class Conta {
	//atributos
	public String clientes; 
	public double saldo;
	
	//construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}
	
	//metodos
	public void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}
	/**
	 * metodo com paramentro(variavel)
	 * @param valor
	 */
	public void despositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ "+ valor);
		
	}
	public void sacar(double valor) {
		saldo -= valor;
		System.out.println("Dédito: R$ "+ valor);
		
	}
	/**
	 * metodo com dois parametros(objeto e variavel)
	 * @param destino
	 * @param valor
	 */
	public void transferir(Conta destino,double valor) {
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
	public double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		
		
		return total;
		
	}
}
