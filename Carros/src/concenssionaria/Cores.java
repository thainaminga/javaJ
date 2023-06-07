package concenssionaria;

public class Cores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro carroFusca = new Carro();
		carroFusca.ano = 2020;
		carroFusca.cor = "Fusca Azul";
		System.out.println(" ");
		System.out.println("Fusca");
		System.out.println("Ano: " + carroFusca.ano);
		System.out.println("Cor: " + carroFusca.cor);
		carroFusca.ligar();
		carroFusca.Acelerar();
		
		Carro carroFerrari = new Carro();
		carroFerrari.ano = 2020;
		carroFerrari.cor = "Vermelha";
		System.out.println(" ");
		System.out.println("Ferrari");
		System.out.println("Ano: " + carroFerrari.ano);
		System.out.println("Cor: " + carroFerrari.cor);
		carroFerrari.ligar();
		carroFerrari.Acelerar();
		
		
		Carro carroCamaroAmarelo = new Carro();
		carroCamaroAmarelo.ano = 2020;
		carroCamaroAmarelo.cor = "Camaro Amarelo";
		System.out.println(" ");
		System.out.println("Camaro");
		System.out.println("Ano: " + carroCamaroAmarelo.ano);
		System.out.println("Cor: " + carroCamaroAmarelo.cor);
		carroCamaroAmarelo.ligar();
		carroCamaroAmarelo.Acelerar();
		
		
		Carro carroUno = new Carro();
		carroUno.ano = 2020;
		carroUno.cor = "Branco";
		System.out.println(" ");
		System.out.println("Uno Quadrado");
		System.out.println("Ano: " + carroUno.ano);
		System.out.println("Cor: " + carroUno.cor);
		carroUno.ligar();
		carroUno.Acelerar();
		
		Carro aviao = new Carro();
		aviao.ano = 2020;
		aviao.cor = "Azul";
		System.out.println(" ");
		System.out.println("Avião");
		System.out.println("Ano: " + aviao.ano);
		System.out.println("Cor: " + aviao.cor);
		aviao.ligar();
		aviao.Acelerar();
		

	}

}
