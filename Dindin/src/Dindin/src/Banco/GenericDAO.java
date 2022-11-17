package Banco;

/**
 * Andre Kaled Duarte Coutinho - 01/10/2022
 * 
 * Classe responsavel pela conexao com o Banco de dados
 * Dispoe de alguns metodos estaticos que trabalham com
 * o Banco de dados criado atualmente */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenericDAO {
	static Connection conexao;

	protected GenericDAO() {
		this.conexao = ConnectionDATABASE.getConnection();
	}

	protected static Connection getConnection() {
		return conexao;
	}

	protected void save(String insertSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
		conexao.close();
	}

	protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
		conexao.close();
	}

	protected void delete(String deleteSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
		conexao.close();
	}
}
