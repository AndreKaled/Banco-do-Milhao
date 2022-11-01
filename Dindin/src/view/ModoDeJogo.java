package view;

/**Andr� Kaled Duarte - 28/09/2022
 * Kauan Ferreira dos Santos - 18/09/2022
 * Graziela da Costa Ralph - 28/09/2022
 * 
 * Modo de Jogo
 * Classe respons�vel pela escolha dentre os dois modos de jogo: F�cil e Dif�cil.
 * essa classe dispara um evento ao clique do usu�rio em algum modo, onde deve 
 * trocar a tela apresentando ao referido modo escolhido.*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModoDeJogo extends JPanel {

	// declara��o de variaveis dos componentes
	private JButton panelVoltar, infoFacil, infoDificil;
	private JPanel telaFacil, telaDificil,telaJogadores = new Jogadores();
	private JLabel lbmodJogo;
	private JBackgroundPanel panelFacil, panelDificil, panelInfoFacil,panelInfoDificil;
	private int contX = 0, contY = 0;
	private JPanel fundo;
	private static String nome = "MODO DE JOGO";
	private ImageIcon 
			imgBtVoltar = new ImageIcon("Imagens/botao voltar.png"),
			imgTitulo = new ImageIcon("Imagens/Modos de Jogo.png"),
			imgInfoFacil = new ImageIcon("Imagens/info roxo.png"),
			imgPanelFacil = new ImageIcon(),
			imgInfoDificil = new ImageIcon("Imagens/info verde.png"),
			imgPanelDificil = new ImageIcon();
	private static String opcao;

	// construtor da classe
	public ModoDeJogo() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		panelVoltar = new JButton(imgBtVoltar);
		try {
			panelFacil = new JBackgroundPanel("imagens/modo facil.png");
			panelDificil = new JBackgroundPanel("imagens/modo dificil.png");
			panelInfoFacil = new JBackgroundPanel("imagens/facil.png");
			panelInfoDificil = new JBackgroundPanel("imagens/dificil.png");
			fundo = new JBackgroundPanel("imagens/fundo tela inicial 1.png");
			fundo.setBounds(0,0,1366,768);
			fundo.setOpaque(false);
			add(fundo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		infoFacil = new JButton(imgInfoFacil);
		lbmodJogo = new JLabel(imgTitulo);
		
		infoDificil = new JButton(imgInfoDificil);
		

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
		infoFacil.setBounds(500, 10, 50, 50);
		infoFacil.setContentAreaFilled(false);
		infoFacil.setBorderPainted(false);
		infoFacil.setVisible(true);
		infoFacil.setFocusable(false);
		panelFacil.add(infoFacil);

		panelInfoFacil.setLayout(null);
		panelInfoFacil.setVisible(false);
		panelInfoFacil.setFocusable(false);
		panelInfoFacil.setOpaque(false);
		panelInfoFacil.setBounds(panelFacil.getBounds());
		fundo.add(panelInfoFacil);

		infoDificil.setLayout(null);
		infoDificil.setBounds(500, 10, 50, 50);
		infoDificil.setContentAreaFilled(false);
		infoDificil.setBorderPainted(false);
		infoDificil.setVisible(true);
		infoDificil.setFocusable(false);
		panelDificil.add(infoDificil);

		panelInfoDificil.setLayout(null);
		panelInfoDificil.setVisible(false);
		panelInfoDificil.setFocusable(false);
		panelInfoDificil.setOpaque(false);
		panelInfoDificil.setBounds(panelDificil.getBounds());
		fundo.add(panelInfoDificil);

		// configura o botao de informacoes do modo facil
		infoFacil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelFacil.setVisible(false);
				infoFacil.setVisible(false);
				panelInfoFacil.setVisible(true);

			}

		});

		// configura a area de informacoes do modo facil
		panelInfoFacil.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e){
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

		panelInfoDificil.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e){
				panelInfoDificil.setVisible(false);
				panelDificil.setVisible(true);
				infoDificil.setVisible(true);

			}
		});
	}

	// configurando pain�is
	private void configuraPanels() {

		panelFacil.setBounds(40, 120, 550, 550);
		panelDificil.setBounds(690, 120, 550, 550);

		panelFacil.setOpaque(false);
		panelDificil.setOpaque(false);
		//panelFacil.setContentAreaFilled(false);
		//panelFacil.setBorderPainted(false);
		//panelFacil.setFocusable(false);
		//panelDificil.setContentAreaFilled(false);
		//panelDificil.setBorderPainted(false);
		//panelDificil.setFocusable(false);

		fundo.add(panelFacil);
		fundo.add(panelDificil);

	}

	// configura a imagem do titulo
	private void configuraTitulo() {
		fundo.add(lbmodJogo);
		lbmodJogo.setBounds(350, 10, 700, 100);
		setVisible(true);
	}

	/** configurando o bot�o de voltar */
	private void configuraBtVoltar() {
		fundo.add(panelVoltar);
		panelVoltar.setBounds(10, 10, 70, 70);
		panelVoltar.setFocusable(false);
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
				contY = 0;
				if (telaFacil == null || contY == 0) {
					telaFacil = new ModoFacil();
					Menu.adicionaTela(telaJogadores, telaJogadores.getName());
					contX++;
				}
				// mudando tela
				Menu.mudaTela(telaJogadores.getName());
				setOpcao(telaFacil.getName());
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
				contX = 0;
				if (telaDificil == null || contX == 0) {
					telaDificil = new ModoDificil();
					Menu.adicionaTela(telaJogadores, telaJogadores.getName());
					contY++;
				}
				// mudando tela
				Menu.mudaTela(telaJogadores.getName());
				setOpcao(telaDificil.getName());
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

	//metodo para capturar a escolha do modo de jogo
	protected void setOpcao(String opcao){
		this.opcao = opcao;
	} 
	protected static String getOpcao(){
		return opcao;
	}
	// fim da classe
}