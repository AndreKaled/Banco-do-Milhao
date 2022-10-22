package Banco;

/**
 * Andre Kaled Duarte - 22/10/2022
 * 
 * Classe usada para conexao com o banco de dados,
 * facilitando o uso em metodos mais simplistas
 * e recuperando dados
 * */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Jogador;

public class JogadorDAO extends GenericDAO{
	String comando;
	// comando para inserir um nome novo na tabela
	public  void novoJogador(Jogador jogador) throws SQLException{
		String nome = jogador.toString();
			comando = "INSERT INTO JOGADOR(nome,pontuacao,vitorias,partidas_jogadas) VALUES (?,?,?,?)";
		save(comando,nome,0,0,0);
	}

	// comando para atualizar as vitorias do jogador
	public void jogadorGanhou(Jogador jogador) throws SQLException{
			comando = "UPDATE Jogador SET vitorias = vitorias +1 WHERE nome = ? ";
			String nome = jogador.toString();
			update(comando,nome);
	}

	// comando para atualizar o score do jogador
	public void atualizaPontuacao(Jogador jogador,int pontos) throws SQLException{
		String nome = jogador.toString();
		int pontuacao = jogador.getScore() + pontos;
		String comando = "UPDATE Jogador SET score = ? WHERE nome = ?";
		update(comando,nome,pontuacao);
		jogador.setScore(pontuacao);
	}

	// comando para retornar uma lista de jogadores
	public ArrayList<Jogador> jogadoresExistentes() throws SQLException {
		ArrayList<Jogador> lista = new ArrayList<Jogador>();
		
		String comando = "SELECT * FROM Jogador";
		PreparedStatement stmt = getConnection().prepareStatement(comando);			
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Jogador jogador = new Jogador();
			jogador.setNickName(rs.getString("nome"));
			jogador.setScore(rs.getInt("pontuacao"));
			jogador.setVitorias(rs.getInt("vitorias"));
			jogador.setPartidasJogadas(rs.getInt("partidas_jogadas"));
			lista.add(jogador);
		}
		
		return lista;
	}

	public boolean verificaJogador(Jogador jogador) throws SQLException{
		ArrayList<Jogador> lista = jogadoresExistentes();
		
		int cont = 0;
		for(Jogador o: lista){
			String nome = o.toString();
			if(nome.equalsIgnoreCase(jogador.toString())){
				cont++;
				break;
			}
		}
		if(cont==0)
			return false;
		else
			return true;
	}
}
