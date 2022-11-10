package modelo;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Jogador {
	private String nickName, cor;
	private int moedas, posicao, score, vitorias = 0, partidasJogadas;
	private Set<Itens> listaCompras = new LinkedHashSet<Itens>();
	private Set<Itens> listaComprados = new LinkedHashSet<Itens>();
	private static int cont = 1;

	// construtor default
	public Jogador() {
		setMoedas(0);
		setPosicao(0);
		setScore(0);
		// setCor(null);
		setNickName("Jogador " + cont);
		cont++;
	}


	// construtor com nome
	public Jogador(String nickName) {
		setNickName(nickName);
		// setCor(null);
		setMoedas(0);
		setPosicao(0);
		setScore(0);
	}

	// construtor com score
	public Jogador(String nickName, int score) {
		setNickName(nickName);
		// setCor(null);
		setMoedas(0);
		setPosicao(0);
		setScore(score);
	}

	// construtor com score e vitorias
	public Jogador(String nickName, int score, int vitorias) {
		setNickName(nickName);
		// setCor(null);
		setMoedas(0);
		setPosicao(0);
		setScore(score);
		setVitorias(vitorias);
	}

	//construtor com todas as inforcoes para apresentar no score do jogo
	public Jogador(String nickName, int score, int vitorias, int partidasJogadas){
		setNickName(nickName);
		setScore(score);
		setVitorias(vitorias);
		setPartidasJogadas(partidasJogadas);
		setMoedas(0);
		setPosicao(0);
	}
	
	// metodos para a compra de itens
	public Set<Itens> verItensComprados() {
		return listaComprados;
	}

	public Set<Itens> verListaDeCompras() {
		return listaCompras;
	}

	// metodo para alterar a posicao
	public void andar(int quant) {
		posicao += quant;
	}

	// metodo para comprar um item
	public boolean comprar(String item) {
		int cont = 0;
		for (Itens o : listaCompras) {
			if (item.equalsIgnoreCase(o.toString()) && moedas >= o.custo()) {
				moedas -= o.custo();
				listaCompras.remove(o);
				listaComprados.add(o);
				cont++;
			}
		}
		if (cont == 1)
			return true;
		else
			return false;
	}

	public int mostraScore() {
		return getScore();
	}

	public int quantMoedas() {
		return getMoedas();
	}

	public void aumentaScore() {
		score++;
	}

	// metodos de acesso aos atributos
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getMoedas() {
		return moedas;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Set<Itens> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(Set<Itens> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public Set<Itens> getListaComprados() {
		return listaComprados;
	}

	public void setListaComprados(Set<Itens> listaComprados) {
		this.listaComprados = listaComprados;
	}
	
	public int getPartidasJogadas() {
		return partidasJogadas;
	}


	public void setPartidasJogadas(int partidasJogadas) {
		this.partidasJogadas = partidasJogadas;
	}


	//sobreescrevendo metodo toString
	public String toString(){
		return nickName +listaCompras;
	}
}
