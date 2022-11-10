package Util;

import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class Teste {
	private static Jogando jogando;

	public static void main(String[] args) {
		Jogando j = new Jogando();
		j.add(new Jogador("André burro"));
		j.add(new Jogador("Raposa 123"));
		j.add(new Jogador("Serginho gameplays"));
		
		j.iniciar();
		System.out.println("----------------");
		Set<Itens> a = j.verLista(0);
		for(Itens i: a)
			System.out.println(i);
	}
}
