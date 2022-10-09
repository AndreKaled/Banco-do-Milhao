package Banco;

import java.util.List;

import modelo.Jogador;

/**
 * Andr� Kaled Duarte Coutinho - 09/1/2022
 * 
 * Classe usada para conex�o com o banco de dados,
 * facilitando o uso em m�todos mais simplistas
 * */

public class Banco {

	//m�todo para inserir novo jogador no banco de dados
	public static void novoJogador(Jogador jogador){
		String nome = jogador.toString();
		ConnectBanco.insertNomeSQL(nome);
	}
	
	//metodo para atualizar as vit�rias do jogador no banco de dados
	public static void ganhou(Jogador jogador){
		String jg = jogador.getNickName();
		ConnectBanco.updateVitoriasSQL(jg);
	}
	
	//alterando score do jogador no banco de dados
	public static void mudaScore(Jogador jogador, int pontuacao){
		String jg = jogador.getNickName();
		ConnectBanco.updateScoreSQL(jg, pontuacao);
	}
	
	public static void mudaScore(Jogador jogador){
		String jg = jogador.getNickName();
		int pontuacao = jogador.getScore();
		ConnectBanco.updateScoreSQL(jg, pontuacao);
	}
	
	//retornando lista de jogadores
	public static List<Jogador> jogadoresExistentes(){
		return ConnectBanco.selectAllSQL();
	}
	
	//retornando top 10 jogadores de acordo com as vit�rias
	//no jogo
	public static List<Jogador> top10Jogadores(){
		List<Jogador> lista = ConnectBanco.ordenaVitorias();
		int cont =0;
		for(Jogador j: lista){
			if(cont<10){
				lista.remove(j);
			}else{
				cont++;
			}
		}
		return lista;
	}
	
	//verificando se o nome j� existe no Banco de dados
	public static boolean verificaJogador(String nome){
		List<Jogador> lista = ConnectBanco.selectAllSQL();
		return lista.contains(nome);
	}
}
