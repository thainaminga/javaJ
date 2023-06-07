package minecraft;

public class Bloco {
	
	//atribotos
	int resisitencia;
	String textura;
	
	//construtor (iniciar um codigo para cada objeto)
	public Bloco() {
		System.out.println(" ");
		System.out.println(" ___ ");
		System.out.println(" $_$ ");
		System.out.println(" ___ ");
		System.out.println(" ");

	}
	
	//metodos 
	//void representa um metodo simples(executa uma ação)
	void construir() {
		System.out.println("Bloco colocado");
		
	}
	
	void minerar() {
		System.out.println("Recursos obtidos");
	}
	
	void craftar() {
		System.out.println("Item criado");
		
	}
	
}
