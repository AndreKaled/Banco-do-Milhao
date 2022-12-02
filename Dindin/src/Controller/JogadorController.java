package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Banco.JogadorDAO;
import modelo.Jogador;

/*
 * Andre Kaled Duarte - 22/10/2022
 * 
 * Classe controladora,de arquitetura para realizar os requerimentos necessarios
 * */

public class JogadorController {

	public void novoJogador(String nome) throws SQLException{
		Jogador jogador = new Jogador(nome);
		new JogadorDAO().novoJogador(jogador);
	}
	
	public void jogadorGanhou(Jogador jogador) throws SQLException{
		new JogadorDAO().jogadorGanhou(jogador);
	}
	
	public void atualizaPontuacao(Jogador jogador, int pontos) throws SQLException{
		new JogadorDAO().atualizaPontuacao(jogador, pontos);
	}
	
	public ArrayList<Jogador> jogadoresExistentes() throws SQLException{
		return new JogadorDAO().jogadoresExistentes();
	}
	
	public boolean verificaJogador(String nome) throws SQLException{
		Jogador jogador = new Jogador(nome);
		return new JogadorDAO().verificaJogador(jogador);
	}
	
	public Jogador encontrarJogador(String jogador) throws SQLException{
		return new JogadorDAO().encontrarJogador(jogador);
	}
}
