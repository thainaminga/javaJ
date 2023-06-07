package concenssionaria;

public class Hangar {
	
	public static void main(String[] args) {
	
	Aviao boeing777 = new Aviao();
	boeing777.ano = 2000;
	boeing777.cor = "Ciano";
	
	System.out.println(" ");
	System.out.println("Boeing 777");
	System.out.println("Ano: " + boeing777.ano);
	System.out.println("Cor: " + boeing777.cor);
	System.out.println("Envergadura: " + boeing777.envergadura);
	boeing777.Acelerar();
	boeing777.Desligar();
	boeing777.Aterrizar();

	}
}