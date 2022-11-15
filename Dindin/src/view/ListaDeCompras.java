package view;

import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Util.Jogando;
import Util.RandomItem;
import modelo.Itens;
import modelo.Jogador;

public class ListaDeCompras extends JFrame {

	JScrollPane scroll;
	JPanel painel;
	Jogando jogando = new Jogando();
	Set<Itens> item;
	Itens[] lista;
	int i;
	Itens[] comprados;
	Set<Itens> set;
	
	public ListaDeCompras() {
		super("Lista De Compras");
		setResizable(false); //Não pemite editar o tamanho
		setSize(200, 250);
		setLocationRelativeTo(null); // posicionando ao centro da tela
		System.out.println("Janela ativada!");
		
		i = jogando.getVez();
		
		inicia();
		adicionaScroll();
		
		setVisible(true);
	}

	private void inicia() {
		// TODO Auto-generated method stub
		item = new Jogando().verLista(i);
		lista = new Itens[item.size()];
		set = new Jogando().getJogador().getListaComprados();
		comprados = new Itens[set.size()];
		
		i=0;
		for(Itens o: item){
			lista[i] = new Itens(o.getItem());
			i++;
		}
		
		i=0;
		for(Itens o: set){
			comprados[i] = new Itens(o.getItem());
			i++;
		}
	}

	public void adicionaScroll() {
		painel = new JPanel();
		painel.setLayout(null);
		scroll = new JScrollPane(painel);

		RandomItem r = new RandomItem();
		
		JLabel[] item = new JLabel[lista.length];
		int i = 0;
		int acresimo = 10;

		for (i = 0; i != lista.length; i++) {

			item[i] = new JLabel("* " + lista[i].toString());
			item[i].setBounds(10, acresimo, 190, 25);
			painel.add(item[i]);

			acresimo += 25;
		}
		
		for(i=0; i!=comprados.length; i++) {
			item[i] = new JLabel("" +comprados[i]);
			
			item[i].setBounds(10, acresimo, 190, 25);
			painel.add(item[i]);
			risca(item[i]);
			
			acresimo += 25;
		}

		add(scroll);
	}
	
	private void risca(JLabel label) {
		label.setText("<html>* <s>  " +label.getText() +" </s></html>");
	}

}
