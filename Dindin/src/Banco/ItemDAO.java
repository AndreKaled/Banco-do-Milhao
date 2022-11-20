package Banco;

import java.sql.SQLException;

import modelo.Itens;

public class ItemDAO extends GenericDAO{

	String comando;
	
	public void novoItem(Itens item) throws SQLException {
		comando = "INSERT INTO ITEM (nome_produto, preco) VALUES(?,?)";
		save(comando, item.getItem(),item.getPreco());
	}
	
	public Itens atualizaItem(Itens item, String novoNome) throws SQLException {
		comando = "UPDATE ITEM SET nome_produto = ? WHERE nome_produto = ?";
		update(comando, item, novoNome);
		item.setItem(novoNome);
		return item;
	}
}
