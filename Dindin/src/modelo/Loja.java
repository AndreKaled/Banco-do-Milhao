package modelo;

import java.util.List;

public class Loja {

	//declação de atributos
	String nome, nomeImagem;
	List<Jogador> listaJogadores;
	List<Itens> listaItens;
	int cod;
	
	//construtores da classe
	public Loja(String nome, List<Itens> listaItens, int cod) {
		super();
		this.nome = nome;
		this.listaItens = listaItens;
		this.cod = cod;
	}

	public Loja(String nome, String nomeImagem, List<Itens> listaItens, int cod) {
		super();
		this.nome = nome;
		this.nomeImagem = nomeImagem;
		this.listaItens = listaItens;
		this.cod = cod;
	}

	public Loja(String nome, String nomeImagem, List<Jogador> listaJogadores, List<Itens> listaItens, int cod) {
		super();
		this.nome = nome;
		this.nomeImagem = nomeImagem;
		this.listaJogadores = listaJogadores;
		this.listaItens = listaItens;
		this.cod = cod;
	}

	//metodos de acesso
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

	public List<Itens> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Itens> listaItens) {
		this.listaItens = listaItens;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
}
