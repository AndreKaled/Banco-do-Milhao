package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class Jogando {

	public static List<Jogador> jogando = new ArrayList<Jogador>();
	private static int vez = 0, tamanho = jogando.size();
	
	//adicionando na lista de quem está jogando
	public void add(Jogador jogador) {
		jogando.add(jogador);
		tamanho = jogando.size();
	}
	
	//capturando a vez do jogador
	public int getVez() {
		return vez;
	}
	
	//passando a vez para o próximo jogador
	public void passarVez() {
		if(vez>=tamanho)
			vez=0;
		else
			vez++;
	}
	
	//método de compra para quando o jogador da vez quiser comprar
	public void pagar(String itemDeCompra) {
		jogando.get(vez).comprar(itemDeCompra);
	}
	
	//gerando lista de compras aleatóriamente por jogador
	private void gerarListaDeCompras() {
		RandomItem r = new RandomItem();
		for(Jogador j: jogando) {
			j.iniciarLista();
			System.out.println("Itens gerado ao jogador " +j);
		}
	}
	
	//retornando lista contendo os itens de compras da vez do jogador no argumento
	public Set<Itens> verLista(int i) {
		return jogando.get(i).getListaCompras();
	}
	
	//chamada do método que inicializa as listas
	public void iniciar() {
		gerarListaDeCompras();
	}
}
