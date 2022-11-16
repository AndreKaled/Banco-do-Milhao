package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionDATABASE {
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/dindin";
	
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		
	private static final String USER = "root";
	
	private static final String PASS = "root";

	public static Connection getConnection() {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL_MYSQL, USER, PASS);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Os seus dados não estão sendo armazenados!");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Base de dados não foi criado ou foi criada incorretamente!");
		}
		return null;
	}
}
