package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class Jogando {

	public static List<Jogador> jogando = new ArrayList<Jogador>();
	private static int vez = 0, tamanho = jogando.size(), MIN = 1;

	// adicionando na lista de quem est� jogando
	public void add(Jogador jogador) {
		jogando.add(jogador);
		tamanho = jogando.size();
		System.out.println("Jogador " + jogador + " adicionado na lista de jogando...");
	}

	// capturando o jogador da vez
	public Jogador getJogador() {
		return jogando.get(vez);
	}

	// capturando a vez do jogador
	public int getVez() {
		return vez;
	}

	// passando a vez para o pr�ximo jogador
	public void passarVez() {
		if (vez >= tamanho - 1)
			vez = 0;
		else
			vez++;
	}

	// m�todo de compra para quando o jogador da vez quiser comprar
	public void pagar(String itemDeCompra) {
		jogando.get(vez).comprar(itemDeCompra);
	}

	// gerando lista de compras aleat�riamente por jogador
	private void gerarListaDeCompras() {
		RandomItem r = new RandomItem();
		for (Jogador j : jogando) {
			j.iniciarLista();
			System.out.println("Itens gerado ao jogador " + j);
		}
	}

	// retornando lista contendo os itens de compras da vez do jogador no
	// argumento
	public Set<Itens> verLista(int i) {
		return jogando.get(i).getListaCompras();
	}

	// chamada do m�todo que inicializa as listas
	public void iniciar() {
		gerarListaDeCompras();
	}

	public int tamanho() {
		return jogando.size();
	}

	public void limpar() {
		jogando.clear();
	}

	public static int getMIN() {
		return MIN;
	}

	public static void setMIN(int mIN) {
		MIN = mIN;
	}

}
