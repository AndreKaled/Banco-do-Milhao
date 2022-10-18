package view;

/**
 * Andre Kaled Duarte - 28/09/2022
 * Tela Principal (MENU) 
 * Essa classe deve representar o a tela Menu do jogo
 * onde o usuario escolhe o que realizar antes do
 * jogo de fato comecar
 * */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {

	private static JPanel c, cLogo, contPrincipal;
	private JButton btJogar, btConfig, btComoJogar, btSair, btPlacar;
	private JLabel versao,Plogo;
	protected static CardLayout card = new CardLayout();;
	private JPanel jogar = new ModoDeJogo();

	ImageIcon logo = new ImageIcon("imagens/logo.png");
	ImageIcon jogo = new ImageIcon("imagens/jogar.png");
	ImageIcon opcoes = new ImageIcon("imagens/opcoes.png");
	ImageIcon tutorial = new ImageIcon("imagens/tutorial.png");
	ImageIcon sair  = new ImageIcon("imagens/sair.png");
	ImageIcon placar = new ImageIcon("imagens/placar.png");
	ImageIcon fundoImg;

	public Menu() {
		super("Din Din");
		// configurando janela
		setLayout(null);
		setSize(1366,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// inicializando componentes
		btJogar = new JButton(jogo);
		btConfig = new JButton(opcoes);
		btComoJogar = new JButton(tutorial);
		btSair = new JButton(sair);
		btPlacar = new JButton (placar);
		cLogo = new JPanel();
		contPrincipal = (JPanel) getContentPane();
		contPrincipal.setLayout(card);
		c = new JPanel();
		c.setBackground(new Color(66, 153, 206));
		c.setLayout(null);
		c.setName("MENU");

		// configurando componentes
		configuraLogo();
		configuraBtJogar();
		configuraBtConfig();
		configuraBtComoJogar();
		configuraBtSair();
		configuraBtPlacar();

		// adicionando componentes
		c.add(cLogo);
		configuraTelas();

		// tratando eventos
		trataEventos();
		setVisible(true);
	}

	// configura a area da logo
	public void configuraLogo() {
		cLogo.setLayout(new FlowLayout());

		// tamanho da logo
		cLogo.setBounds(380, 60, 600, 300);
		Plogo = new JLabel(logo);
		cLogo.setOpaque(false);
		cLogo.add(Plogo);
	}

	// configura o botao de jogar
	public void configuraBtJogar() {
		btJogar.setBounds(505, 380, 340, 70);
		btJogar.setContentAreaFilled(false);
        btJogar.setBorderPainted(false);
		c.add(btJogar);
	}

	// configura o botao de configuracoes
	public void configuraBtConfig() {
		btConfig.setBounds(505, 460, 160, 70);
		btConfig.setContentAreaFilled(false);
        btConfig.setBorderPainted(false);
		c.add(btConfig);
	}

	// configura o botao de como Jogar (tutorial)
	public void configuraBtComoJogar() {
		btComoJogar.setBounds(680,460, 160, 70);
		btComoJogar.setContentAreaFilled(false);
        btComoJogar.setBorderPainted(false);
		c.add(btComoJogar);
	}

	// configura o botoes de sair do jogo
	public void configuraBtSair() {
		btSair.setBounds(1200, 640, 150, 60);		
		btSair.setContentAreaFilled(false);
        btSair.setBorderPainted(false);
		c.add(btSair);
	}
	
	public void configuraBtPlacar() {
		btPlacar.setBounds(-30, 630, 340, 70);
		btPlacar.setContentAreaFilled(false);
        btPlacar.setBorderPainted(false);
		c.add(btPlacar);
	}

	// configurando telas com o CardLayout
	protected void configuraTelas() {
		contPrincipal.add(c, c.getName());
		contPrincipal.add(jogar, jogar.getName());
	}

	// metodos para manipulacao do Container Principal
	static public void mudaTela(String nomeTela) {
		card.show(contPrincipal, nomeTela);
	}

	static public void adicionaTela(JPanel painel, String nomeTela) {
		if (painel != null) {
			contPrincipal.add(painel, nomeTela);
		} else {
			System.err.println("ERRO");
		}
	}

	static public void voltaTela() {
		card.previous(contPrincipal);
	}
	
	public static void menu(){
		card.first(contPrincipal);
	}

	//tratando eventos
	public void trataEventos() {
		btSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConfirmaSair();
			}
		});

		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaTela(jogar.getName());
			}

		});
		
		btPlacar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Score();
			}
			
		});
	}

	public static void main(String[] args) {
		new Menu();
	}
}
