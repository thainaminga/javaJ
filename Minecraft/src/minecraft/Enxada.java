package minecraft;

//extends = heransa
public class Enxada extends Bloco {
	
	//atributos
	//boolean (variável - true / false)
	boolean conquista;
	
	//métodos
	public Enxada() {
		System.out.println(" _");
		System.out.println("/");
	}
	public void arar() {
		System.out.println("!!! Terra arada !!!");
		conquista = true;
	}
	//uso do polimorfismo para modificar 
	//o comportamento de um metodo 
	//obrigatorio usar omesmo nome de metodo
	public void minerar() {
		System.out.println(" Dano Causado! ");
	}

}
