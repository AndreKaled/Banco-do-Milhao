package modelo;

/**André Kaled Duarte - 29/08/2022
 * DADO, classe usada para a movimentação dos personagens durante o 
 * jogo no tabuleiro*/

import java.util.Random;

//final para nï¿½o ser possï¿½vel heranï¿½a, sem utilidade herdar desta classe.
public final class Dado {

	// classe geradora de numeros pseudoaleatï¿½rios
	static Random dado = new Random();
	private int valor;

	// consutor default
	public Dado() {
		// default
	}

	// metodo estï¿½tico para rolar um dado padrï¿½o (D6)
	public int rolar() {
		setValor(dado.nextInt(6) + 1);
		return getValor();
	}

	// metodo para rolar um dado de n lados (D4, D8, D10, D20, ...)
	public int rolar(int lados) {
		return dado.nextInt(lados) + 1;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}