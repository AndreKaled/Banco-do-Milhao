package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModoDeJogo extends JPanel {

	// declaração de variaveis dos componentes
	private JButton panelFacil, panelDificil, panelVoltar, infoFacil, panelInfoFacil, infoDificil, panelInfoDificil;
	private JPanel telaFacil = new ModoFacil(),
			telaDificil = new ModoDificil();
	private JLabel lbmodJogo;
	private int contX = 0, contY = 0;
	// private JPanel c;
	private static String nome = "MODO DE JOGO";
	private ImageIcon imgFacil = new ImageIcon(getClass().getResource("modo facil.png")),
			imgDificil = new ImageIcon(getClass().getResource("modo dificil.png")),
			imgBtVoltar = new ImageIcon(getClass().getResource("botao voltar.png")),
			imgTitulo = new ImageIcon(getClass().getResource("Modos de Jogo.png")),
			imgInfoFacil = new ImageIcon(getClass().getResource("info roxo.png")),
			imgPanelFacil = new ImageIcon(getClass().getResource("facil.png")),
			imgInfoDificil = new ImageIcon(getClass().getResource("info verde.png")),
			imgPanelDificil = new ImageIcon(getClass().getResource("dificil.png"));

	// construtor da classe
	public ModoDeJogo() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		panelVoltar = new JButton(imgBtVoltar);
		panelFacil = new JButton(imgFacil);
		panelDificil = new JButton(imgDificil);
		infoFacil = new JButton(imgInfoFacil);
		lbmodJogo = new JLabel(imgTitulo);
		panelInfoFacil = new JButton(imgPanelFacil);
		infoDificil = new JButton(imgInfoDificil);
		panelInfoDificil = new JButton(imgPanelDificil);

		configuraPanels();
		configuraBtVoltar();
		configuraTitulo();
		configuraBtInfo();
		eventos();

		// nome do painel para mudar de tela no cardLayout
		setName(nome);
	}

	public void configuraBtInfo() {
		infoFacil.setLayout(null);
		infoFacil.setBounds(100, 10, 700, 610);
		infoFacil.setContentAreaFilled(false);
		infoFacil.setBorderPainted(false);
		infoFacil.setVisible(true);
		panelFacil.add(infoFacil);

		panelInfoFacil.setLayout(null);
		panelInfoFacil.setVisible(false);
		panelInfoFacil.setContentAreaFilled(false);
		panelInfoFacil.setBorderPainted(false);
		panelInfoFacil.setBounds(20, 80, 650, 600);
		add(panelInfoFacil);

		infoDificil.setLayout(null);
		infoDificil.setBounds(700, 200, 700, 610);
		infoDificil.setContentAreaFilled(false);
		infoDificil.setBorderPainted(false);
		infoDificil.setVisible(true);
		panelDificil.add(infoDificil);

		panelInfoDificil.setLayout(null);
		panelInfoDificil.setVisible(false);
		panelInfoDificil.setContentAreaFilled(false);
		panelInfoDificil.setBorderPainted(false);
		panelInfoDificil.setBounds(690, 80, 650, 600);
		add(panelInfoDificil);

		// configura o botao de informações do modo facil
		infoFacil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelFacil.setVisible(false);
				infoFacil.setVisible(false);
				panelInfoFacil.setVisible(true);

			}

		});

		// configura a area de informações do modo facil
		panelInfoFacil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelInfoFacil.setVisible(false);
				panelFacil.setVisible(true);
				infoFacil.setVisible(true);

			}

		});

		infoDificil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelDificil.setVisible(false);
				infoDificil.setVisible(false);
				panelInfoDificil.setVisible(true);

			}

		});

		panelInfoDificil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelInfoDificil.setVisible(false);
				panelDificil.setVisible(true);
				infoDificil.setVisible(true);

			}

		});
	}

	// configurando painéis
	private void configuraPanels() {

		panelFacil.setBounds(20, 80, 650, 600);
		panelDificil.setBounds(690, 80, 650, 600);

		panelFacil.setContentAreaFilled(false);
		panelFacil.setBorderPainted(false);
		panelDificil.setContentAreaFilled(false);
		panelDificil.setBorderPainted(false);

		add(panelFacil);
		add(panelDificil);

	}

	// configura a imagem do titulo
	private void configuraTitulo() {
		add(lbmodJogo);
		lbmodJogo.setBounds(350, 10, 700, 100);
		setVisible(true);
	}

	/** configurando o botão de voltar */
	private void configuraBtVoltar() {
		add(panelVoltar);
		panelVoltar.setBounds(10, 10, 70, 70);
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