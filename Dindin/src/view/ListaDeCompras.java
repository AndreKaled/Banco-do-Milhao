package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Util.RandomItem;
import modelo.Itens;

public class ListaDeCompras extends JFrame {

	JScrollPane scroll;
	JPanel painel;

	public ListaDeCompras() {
		super("Lista De Compras");
		// setResizable(false); //Não pemite editar o tamanho
		setSize(200, 250);
		setLocationRelativeTo(null); // posicionando ao centro da tela
		System.out.println("Janela ativada!");
		adicionaScroll();

		setVisible(true);
		
	}

	public void adicionaScroll() {
		painel = new JPanel();
		painel.setLayout(null);
		scroll = new JScrollPane(painel);

		RandomItem r = new RandomItem();
		Itens[] lista = r.verItens();
		JLabel[] item = new JLabel[lista.length];
		int i = 0;
		int acresimo = 10;

		for (i = 0; i != lista.length; i++) {

			item[i] = new JLabel("* " + lista[i].toString());
			item[i].setBounds(10, acresimo, 190, 25);
			painel.add(item[i]);

			acresimo += 25;
		}

		add(scroll);
	}

}
