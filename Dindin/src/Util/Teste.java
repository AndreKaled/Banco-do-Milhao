package Util;

import java.util.Scanner;
import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class Teste {
	private static Jogando jogando;

	public static void main(String[] args) {
		Jogando j = new Jogando();
		Jogador andre = new Jogador("André FuncionaPraga");
		Jogador raposa = new Jogador("Raposa 123");
		Jogador sergio = new Jogador("Serginho gameplays");
		j.add(andre);
		j.add(raposa);
		j.add(sergio);
		
		j.iniciar();
		System.out.println("----------------");
		Set<Itens> a = j.verLista(0);
		for(Itens i: a)
			System.out.println(i);
		Scanner s = new Scanner(System.in);
		System.out.print("Compra:");
		String c = s.nextLine();
		System.out.println(andre.comprar(c));
		a = andre.getListaComprados();
		for(Itens i: a)
			System.out.println(i);
		
	}
}
