
/**
 * André Kaled Duarte e Kauan Ferreira dos Santos - 15/09/2022
 *
 * Tela Principal (MENU) 
 * 
 * Essa classe deve representar a tela Menu do jogo
 * onde o usuário escolhe qual ao realizar antes do
 * jogo de fato começar
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

	//declaração dos componentes
	private static JPanel c, cLogo, contPrincipal;
	private JButton btJogar, btConfig, btComoJogar, btSair;
	private JLabel versao,Plogo;
	
	//declaração dos objetos para a "troca" de telas
	protected static CardLayout card = new CardLayout();;
	private JPanel jogar = new ModoDeJogo();

	//declaração das imagens a ser usadas na tela de menu
	ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
	ImageIcon jogo = new ImageIcon(getClass().getResource("jogar.png"));
	ImageIcon opcoes = new ImageIcon(getClass().getResource("opcoes.png"));
	ImageIcon tutorial = new ImageIcon(getClass().getResource("tutorial.png"));
	ImageIcon sair  = new ImageIcon(getClass().getResource("sair.png"));
	ImageIcon fundoImg;

	//construtor da classe de menu, que inicia o JFrame também
	public Menu() {
		super("Din Din");
		// configurando janela
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// inicializando componentes
		btJogar = new JButton(jogo);
		btConfig = new JButton(opcoes);
		btComoJogar = new JButton(tutorial);
		btSair = new JButton(sair);
		cLogo = new JPanel();
		versao = new JLabel("Versï¿½o beta");
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
		configuraVersao();

		// adicionando componentes
		c.add(cLogo);
		configuraTelas();

		// tratando eventos
		trataEventos();
		setVisible(true);
	}

	// configura a área da logo
	private void configuraLogo() {
		cLogo.setLayout(new FlowLayout());

		// tamanho da logo
		cLogo.setBounds(380, 60, 600, 300);
		Plogo = new JLabel(logo);
		cLogo.add(Plogo);
	}

	// configura o botão de jogar
	private void configuraBtJogar() {
		btJogar.setBounds(505, 380, 340, 70);
		btJogar.setContentAreaFilled(false);
        btJogar.setBorderPainted(false);
		c.add(btJogar);
	}

	// configura o botao de configurações
	private void configuraBtConfig() {
		btConfig.setBounds(505, 460, 160, 70);
		btConfig.setContentAreaFilled(false);
        btConfig.setBorderPainted(false);
		c.add(btConfig);
	}

	// configura o botao de como Jogar (tutorial)
	private void configuraBtComoJogar() {
		btComoJogar.setBounds(680,460, 160, 70);
		btComoJogar.setContentAreaFilled(false);
        btComoJogar.setBorderPainted(false);
		c.add(btComoJogar);
	}

	// configura o botão de sair do jogo
	private void configuraBtSair() {
		btSair.setBounds(1200, 640, 150, 60);		
		btSair.setContentAreaFilled(false);
        btSair.setBorderPainted(false);
		c.add(btSair);
	}

	// configurando telas com o CardLayout
	protected void configuraTelas() {
		contPrincipal.add(c, c.getName());
		contPrincipal.add(jogar, jogar.getName());
	}

	// metodos para manipulação do Container Principal, este troca pelo nome
	static public void mudaTela(String nomeTela) {
		card.show(contPrincipal, nomeTela);
	}

	//metodo para adicionar as outras telas
	static public void adicionaTela(JPanel painel, String nomeTela) {
		if (painel != null) {
			contPrincipal.add(painel, nomeTela);
		} else {
			System.err.println("ERRO");
		}
	}

	//metodo para retornar a uma tela anterior, mas por ordem de adição
	static public void voltaTela() {
		card.previous(contPrincipal);
	}

	// area de controle de versï¿½o
	public void configuraVersao() {
		versao.setBounds(10, 660, 100, 50);
		c.add(versao);
	}

	//tratando eventos dos componentes
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
	}

	//Main
	public static void main(String[] args) {
		new Menu();
	}
}