package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Util.Jogando;
import modelo.Jogador;

public class Tabuleiro extends JPanel {

	int linha = 6, coluna = 9;
	int cont = 0, caminho = linha * coluna;
	JPanel[] p = new JBackgroundPanel[caminho];

	public Tabuleiro() {
		setLayout(new GridLayout(linha, coluna));
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
			if (true) {
				if (cont % 2 == 0) {
					p[cont] = new JBackgroundPanel(b);
				} else {
					p[cont] = new JBackgroundPanel(a);
				}
				p[cont].setLayout(new FlowLayout());

				add(p[cont]);

				if (cont % 2 == 0) {
					p[cont].add(new JLabel("" + cont));
				} else {
					p[cont].add(new JLabel("" + cont));
				}

				cont++;
			}
		}
	}

	public void inicia(JComponent peca) {
		p[0].add(peca);
	}

	public JPanel setP(int indice) {
		return p[indice];
	}

	public class Move extends Thread {

		int num = 0;
		JComponent pessoa;
		int posicaoAntiga = 0, posicaoNova;

		public Move() {

		}

		public void mover(JComponent peca, int valor) {
			this.num = valor;
			this.pessoa = peca;
			run();
		}

		@Override
		public void run() {
			repaint();
			Jogador j = new Jogando().getJogador();
			System.out.println("Resultado:" + num + "\n");
			System.out.println("Posicao antiga: " +j.getPosicao());
			posicaoAntiga = j.getPosicao();
			
			do {
				try {
					sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					p[posicaoAntiga].remove(pessoa);

					System.out.println("Andando...");

					switch(posicaoAntiga) {
					case 8:
						posicaoNova = 17;
						break;
					case 17:
						posicaoNova = 26;
						break;
					case 26:
						posicaoNova = 35;
						break;
					case 35:
						posicaoNova = 44;
						break;
					case 44:
						posicaoNova = 53;
						break;
					case 53:
						posicaoNova = 52;
						break;
					case 52:
						posicaoNova = 51;
						break;
					case 51:
						posicaoNova = 50;

					case 50:
						posicaoNova = 49;
						break;
					case 49:
						posicaoNova = 48;
						break;
					case 48:
						posicaoNova = 47;
						break;
					case 47:
						posicaoNova = 46;
						break;
					case 46:
						posicaoNova = 45;
						break;
					case 45:
						posicaoNova = 36;
						break;
					case 36:
						posicaoNova = 27;
						break;
					case 27:
						posicaoNova = 18;
						break;
					case 18:
						posicaoNova = 9;
						break;

					case 9:
						posicaoNova = 0;
						break;
					default:
						posicaoNova = posicaoAntiga+1;
						break;
					}

					posicaoAntiga = posicaoNova;

					p[posicaoNova].add(pessoa);

					num--;

					repaint();
				}

			} while (num != 0);
			j.setPosicao(posicaoNova);
			System.out.println("Posicao atual: " +j.getPosicao());
			System.out.println("\nParou!\n");

		}
	}
}
