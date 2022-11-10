package Util;

import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class Teste {
	private static Jogando jogando;

	public static void main(String[] args) {
		Jogando j = new Jogando();
		Jogador andre = new Jogador("André K");
		Jogador raposa = new Jogador("Raposa 123");
		Jogador sergio = new Jogador("Serginho gameplays");
		
		j.add(andre);
		j.add(raposa);
		j.add(sergio);
		
		j.iniciar();
		System.out.println("----------------");
		System.out.println(andre);
		System.out.println(raposa);
		System.out.println(sergio);
	}
}
