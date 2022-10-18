package view;

/**
 * Andre Kaled Duarte Coutinho - 17/10/2022
 * 
 * Tela desenvolvida para visualizacao do Score de quem jogou 
 * */
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Jogador;
import Banco.Banco;

public class Score extends JFrame {

	DefaultTableModel model;
	static JTable tabela;
	JScrollPane scroll;
	String[] colunas = { "NickName", "Score", "Vitórias" };
	Object[][] conteudo;

	public Score() {
		super("Score de Jogadores");
		setSize(350, 300);
		setLocationRelativeTo(null);
		
		model = new DefaultTableModel(conteudo, colunas);
		tabela = new JTable(model);
		scroll = new JScrollPane(tabela);
		
		atualizaTabela();

		tabela.setEnabled(false); 
		
		add(scroll);

		setVisible(true);
	}

	public static void atualizaTabela() {
		TableModel tTabela = (DefaultTableModel) tabela.getModel();
		((DefaultTableModel) tTabela).setNumRows(0);

		List<Jogador> jogadores = Banco.jogadoresExistentes();

		for (int linha = 0; linha < jogadores.size(); linha++) {
			Jogador jogador = jogadores.get(linha);

			((DefaultTableModel) tTabela).addRow(new Object[] { 1 });

			tabela.setValueAt(jogador.getNickName(), linha, 0);
			tabela.setValueAt(jogador.getScore(), linha, 1);
			tabela.setValueAt(jogador.getVitorias(), linha, 2);
		}
	}
}
