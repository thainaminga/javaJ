package minecraft;

public class Mundo {
	public static void main(String[] args) {
	//instanciar (criar) um objeto
	Bloco blocoTerra = new Bloco();
	blocoTerra.resisitencia = 1;
	blocoTerra.textura = "Terra";
	System.out.println("Bloco" + blocoTerra.textura);
	System.out.println("Resistência: " + blocoTerra.resisitencia);
	blocoTerra.construir();
	blocoTerra.minerar();
	
	Bloco blocoMadeira = new Bloco();
	blocoMadeira.resisitencia = 2;
	blocoMadeira.textura = "Madeira";
	System.out.println("Bloco" + blocoMadeira.textura);
	System.out.println("Resistência: " + blocoMadeira.resisitencia);
	blocoMadeira.minerar();
	blocoMadeira.craftar();
	
	//INSTANCIAR UMA ENXADA DE PEDRA
	Enxada enxadaPedra = new Enxada();
	enxadaPedra.textura = "Pedra";
	enxadaPedra.resisitencia = 5;
	System.out.println("Enxada de " + enxadaPedra.textura);
	System.out.println("Resistência: " + enxadaPedra.resisitencia);
	enxadaPedra.minerar();
	//
	if(enxadaPedra.conquista == true) {
		System.out.println("____________________________________");
		System.out.println(" Conquista obtida! ");
		System.out.println(" Dedidcação séria. Hora do plantio. ");
		System.out.println("____________________________________");
		
	}
	
	//INSTANCIAR UMA ENXADA DE PEDRA
		Enxada enxadaMadeira = new Enxada();
		enxadaMadeira.textura = "Madeira";
		enxadaMadeira.resisitencia = 2;
		System.out.println("Enxada de " + enxadaMadeira.textura);
		System.out.println("Resistência: " + enxadaMadeira.resisitencia);
		enxadaMadeira.minerar();
		//
		if(enxadaMadeira.conquista == true) {
			System.out.println("____________________________________");
			System.out.println(" Conquista obtida! ");
			System.out.println(" Dedidcação séria. Hora do plantio. ");
			System.out.println("____________________________________");
			
		}
	}
	

}
