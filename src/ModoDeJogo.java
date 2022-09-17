/**André Kaled Duarte - 08/09/2022
 * 
 * Modo de Jogo
 * Classe responsável pela escolha dentre os dois modos de jogo: Fácil e Difícil.
 * essa classe dispara um evento ao clique do usuário em algum modo, onde deve 
 * trocar a tela apresentando ao referido modo escolhido.*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ModoDeJogo extends JPanel {

	// declaração de variaveis dos componentes
	private JPanel panelFacil, panelDificil;
	private JButton btVoltar;
	private JPanel telaFacil = new ModoFacil(),
			telaDificil = new ModoDificil();
	private int contX = 0, contY = 0;
	private JPanel c;
	private static String nome = "MODO DE JOGO";
	
	// construtor da classe
	public ModoDeJogo() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		panelFacil = new JPanel();
		panelDificil = new JPanel();
		btVoltar = new JButton("VOLTAR");
		c = new JPanel();
		configuraPanels();
		configuraBtVoltar();
		eventos();

		// nome do painel para mudar de tela no cardLayout
		setName(nome);
	}

	// configurando painéis
	private void configuraPanels() {
		panelFacil.setBounds(205, 150, 400, 300);
		panelDificil.setBounds(625, 150, 400, 300);
		panelFacil.setBackground(Color.BLACK);
		panelDificil.setBackground(Color.BLACK);

		add(panelFacil);
		add(panelDificil);
	}

	/** configurando o botão de voltar */
	private void configuraBtVoltar() {
		btVoltar.setBounds(10, 10, 100, 20);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.voltaTela();
			}

		});
	}

	/**
	 * Tratando eventos de clique, é uma área de escolha de dois modos de jogo
	 * então ao clicar em uma opção, a configuração deve alterar e a tela também
	 */
	private void eventos() {
		panelFacil.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// adicionando ao cardLayout
				if (telaFacil == null || contY == 0) {
					telaFacil = new ModoFacil();
					Menu.adicionaTela(telaFacil, telaFacil.getName());
					contY++;
				}
				// mudando tela
				Menu.mudaTela(telaFacil.getName());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		panelDificil.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				// adicionando ao cardLayout
				if (telaDificil == null || contX == 0) {
					telaDificil = new ModoDificil();
					Menu.adicionaTela(telaDificil, telaDificil.getName());
					contX++;
				}
				// mudando tela
				Menu.mudaTela(telaDificil.getName());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	// metodo de acesso ao nome da classe
	static protected String getNome() {
		return nome;
	}
	
	// fim da classe
}
