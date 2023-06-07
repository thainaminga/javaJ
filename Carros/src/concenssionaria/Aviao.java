package concenssionaria;

import java.util.Random;

public class Aviao extends Carro {
	
	double envergadura;
	
	int ano;
	String cor;
	public Aviao() {
		System.out.println("________________________________________________________________");
	
	}
	void Aterrizar() {
		System.out.println(" Pousou! ");
		
	}//polimorfismo
	public void Acelerar() {
		System.out.println(" Decolou! ");
		}

}
