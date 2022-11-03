package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel {

	int linha = 6, coluna = 9;
	int cont = 0, caminho = linha*coluna;
	JPanel[] p = new JBackgroundPanel[caminho];
	
	public Tabuleiro() {
		setLayout(new GridLayout(linha,coluna));
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() throws IOException {
		
		String b = "imagens/Vector.png";
		String a = "imagens/Vector (1).png";

		while (cont != caminho) {
			if(true){
			if (cont % 2 == 0) {
				p[cont] = new JBackgroundPanel(b);
			} else {
				p[cont] = new JBackgroundPanel(a);
			}
			p[cont].setLayout(new FlowLayout());

			add(p[cont]);

			if (cont % 2 == 0) {
				p[cont].add(new JLabel(""+cont));
			} else {
				p[cont].add(new JLabel(""+cont));
			}
			

			// linhas
			/**
			 * if (true /* cont >= 0 && cont <= 5 ) { JLabel l = new JLabel("" +
			 * cont); if (cont % 2 == 0) { b.add(l); add(b); } else { a.add(l);
			 * add(a); } }
			 */

			cont++;
			}
		}
	}
	public JPanel setP(int indice){
		return p[indice];
	}
	
	public class Move extends Thread {
		public Move() {
			start();
		}

		@Override
		public void run() {
			Scanner s = new Scanner(System.in);
			JLabel pessoa = new JLabel("to aqui");

			for (int i = 0; i < 9; i++)
				p[i].add(new JLabel("" + i));
			p[0].add(pessoa);
			int posicaoAntiga = 0, posicaoNova;

			while (true) {
				System.out.print("Digita um numero para avançar casas pfvzinho:");
				int num = s.nextInt();

				do {
					try {
						sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						p[posicaoAntiga].remove(pessoa);
						
						System.out.println("Andando...");

						posicaoNova = posicaoAntiga + 1;

						if (posicaoNova == 8)
							posicaoNova = 0;

						posicaoAntiga = posicaoNova;

						p[posicaoNova].add(pessoa);
						
						repaint();
						num--;
					}
				} while (num != 0);
			}
		}
	}
}
