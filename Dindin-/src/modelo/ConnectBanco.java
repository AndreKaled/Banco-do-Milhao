package modelo;

/**
 * André Kaled Duarte Coutinho - 01/10/2022
 * 
 * Classe responsável pela conexão com o Banco de dados
 * Dispõe de alguns métodos estáticos que trabalham com
 * o Banco de dados criado atualmente */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public final class ConnectBanco {

	private static String comandoSQL = null;
	private static PreparedStatement state ;
	private static Connection conexao = getConnection();
	
	//comandos em SQL iniciais da classe
	//comando para inserir um nome novo na tabela
	public static boolean insertNomeSQL(String nomeJogador){
		try{
			setComandoSQL("INSERT INTO JOGADOR VALUES ('" +nomeJogador +"', 0, 0);");
			state = conexao.prepareStatement(getComandoSQL());
			state.execute();
			return true;
		}catch(Exception e){System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return false;
		}
	}
	
	//comando para atualizar as vitorias do jogador
	public static boolean updateVitoriasSQL(String nomeJogador){
		try{
			setComandoSQL("UPDATE Jogador SET vitorias = vitorias +1 WHERE nome = '" +nomeJogador +"'");
			state = conexao.prepareStatement(getComandoSQL());
			state.execute();
			return true;
		}catch(Exception e){
			System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return false;
		}
	}
	
	//comando para atualizar o score do jogador
	public static boolean updateScoreSQL(String nomeJogador, int score){
		try{
			setComandoSQL("UPDATE Jogador SET score = score +" +score +" WHERE nome = '" +nomeJogador +"'");
			state = conexao.prepareStatement(getComandoSQL());
			state.execute();
			return true;
		}catch(Exception e){
			System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return false;
		}
	}
	
	//comando para buscar o score do jogador
	@SuppressWarnings("null")
	public static int selectScoreSQL(String nomeJogador){
		try{
			setComandoSQL("SELECT score as Score FROM Jogador where nome = '" +nomeJogador +"';");
			state = conexao.prepareStatement(comandoSQL);
			ResultSet resultados = state.executeQuery();
			int score = 0;
			while(resultados.next()){
				String a = resultados.getString("Score");
				score = Integer.parseInt(a);
			}
			
			return score;
		}catch(Exception e){
			System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return (Integer) null;
		}
	}
	
	//comando para buscar a quantidade de partidas ganhas
	@SuppressWarnings("null")
	public static int selectVitoriasSQL(String nomeJogador){
		try{
			setComandoSQL("SELECT vitorias as Vitorias FROM Jogador where nome = '" +nomeJogador +"';");
			state = conexao.prepareStatement(comandoSQL);
			ResultSet resultados = state.executeQuery();
			int vitorias = 0;
			while(resultados.next()){
				String a = resultados.getString("Vitorias");
				vitorias = Integer.parseInt(a);
			}
			
			return vitorias;
		}catch(Exception e){
			System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return (Integer) null;
		}
	}
	
	//comando para retornar uma lista de jogadores
	public static List<Jogador> selectAllSQL(){
		List<Jogador> lista = new ArrayList<Jogador>();
		try{
			setComandoSQL("SELECT * FROM Jogador");
			state = conexao.prepareStatement(comandoSQL);
			ResultSet resultados = state.executeQuery();
			while(resultados.next()){
				String nome = resultados.getString("Nome");
				String ScoreString = resultados.getString("Score");
				String vitoriasString = resultados.getString("Vitorias");
				int score = Integer.parseInt(ScoreString);
				int vitorias = Integer.parseInt(vitoriasString);
				Jogador jogador = new Jogador(nome,score,vitorias);
				lista.add(jogador);
			}
			return lista;
		}catch(Exception e){
			System.out.println("Opa! parece que ocorreu algum problema com a conexão, me desculpe amiguinho :(");
			e.printStackTrace();
			return null;
		}
	}
	
	//metodos de acesso
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/dindin","root","root");
		}catch(Exception e){
			return null;
		}
	}
	
	public static String getComandoSQL(){
		return comandoSQL;
	}
	
	public static void setComandoSQL(String comando){
		comandoSQL = comando;
	}
}
