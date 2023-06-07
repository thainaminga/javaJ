package concenssionaria;

import java.util.Random;

public class Carro {
	
	//
	int ano;
	String cor;
	
	public Carro() {
		System.out.println("________________________________________________________________");
		//
		//
		String chassi = new String("12345678901234567890abcdefghijk");
		//
		//
		Random gerador = new Random();
		System.out.println("Chassi: * ");
		//
		for (int i = 1; i < 16; i++) {
			//
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
			
		}
		System.out.println(" *");
	}
	
	//
	void ligar() {
		System.out.println("Motor ligado");
		
	}
	
	//
	void Acelerar() {
		System.out.println("Vrummm Vrummm...");
		
	}
	
	//
	void Desligar() {
		System.out.println("Motor Desligado");
		
	}

}
