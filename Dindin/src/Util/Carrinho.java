package Util;

import java.util.ArrayList;
import java.util.List;

import modelo.Itens;
import modelo.Jogador;

public class Carrinho {

	Jogador jogador;
	List<Itens> listaItens;
	int custoTotal;

	public Carrinho(Jogador jogador) {
		this.jogador = jogador;
		listaItens = new ArrayList<Itens>();
		custoTotal = 0;
	}

	// adicionando ao carrinho de compras
	public void adiciona(Itens item) {
		listaItens.add(item);
		custoTotal += item.custo();
	}

	// retirando do carrinho de compras
	public void remove(Itens item) {
		listaItens.remove(item);
		custoTotal -= item.custo();
	}

	public int custoTotal() {
		return custoTotal;
	}

	// validando compra dos itens pelo jogador
	public boolean validaCompra() {
		return jogador.getMoedas() >= custoTotal;
	}

	public void comprar() {
		if (validaCompra()) {
			for (Itens i : listaItens)
				jogador.comprar(i.toString());
			System.out.println("Jogador " + jogador + "comprou todos os itens!");
		} else
			System.out.println("Compra de itens impossível com poucas moedas!\nCusto: " + custoTotal
					+ "\nMoedas do jogador: " + jogador.getMoedas());
	}
}
