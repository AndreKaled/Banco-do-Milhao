package view;

/**Andr� Kaled Duarte - 18/09/2022
 * Kauan Ferreira dos Santos - 18/09/2022
 * Graziela da Costa Ralph - 20/09/2022
 * 
 * Modo de Jogo
 * Classe respons�vel pela escolha dentre os dois modos de jogo: F�cil e Dif�cil.
 * essa classe dispara um evento ao clique do usu�rio em algum modo, onde deve 
 * trocar a tela apresentando ao referido modo escolhido.*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ModoDeJogo extends JPanel {
	// declara��o de variaveis dos componentes
	private JButton panelFacil, panelDificil, panelVoltar;
	private JPanel telaFacil = new ModoFacil(),
			telaDificil = new ModoDificil();
	private int contX = 0, contY = 0;
	private JPanel c;
	private static String nome = "MODO DE JOGO";
	private ImageIcon imgFacil = new ImageIcon(getClass().getResource("modo facil.png")),
			imgDificil = new ImageIcon(getClass().getResource("modo dificil.png")), 
			imgBtVoltar = new ImageIcon(getClass().getResource ("botao voltar.png"));

	// construtor da classe
	public ModoDeJogo() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		panelVoltar = new JButton(imgBtVoltar);
		panelFacil = new JButton(imgFacil);
		panelDificil = new JButton(imgDificil);
		c = new JPanel(null);
		configuraPanels();
		configuraBtVoltar();
		eventos();

		// nome do painel para mudar de tela no cardLayout
		setName(nome);
	}

	// configurando pain�is
	private void configuraPanels() {
		c.setBounds(20,80,1350,1200);
		c.setBackground(new Color(66, 153, 206));
		add(c);
		
		panelFacil.setBounds(0, 0, 650, 600);
		panelDificil.setBounds(670, 0, 650, 600);
		
		panelFacil.setContentAreaFilled(false);
		panelFacil.setBorderPainted(false);
		panelDificil.setContentAreaFilled(false);
		panelDificil.setBorderPainted(false);

		c.add(panelFacil);
		c.add(panelDificil);
	}

	/** configurando o bot�o de voltar */
	private void configuraBtVoltar() {
		add(panelVoltar);
		panelVoltar.setBounds (10, 10, 50, 50);
		panelVoltar.setContentAreaFilled(false);
		panelVoltar.setBorderPainted(false);

		panelVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.voltaTela();
			}

		});
	}

	/**
	 * Tratando eventos de clique, � uma �rea de escolha de dois modos de jogo
	 * ent�o ao clicar em uma op��o, a configura��o deve alterar e a tela tamb�m
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

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

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

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});
	}

	// metodo de acesso ao nome da classe
	static protected String getNome() {
		return nome;
	}

	// fim da classe

}