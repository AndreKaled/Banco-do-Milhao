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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import som.Efeito;
import som.Som;

public class Menu extends JFrame {

	private static JPanel c, cLogo, contPrincipal;
	private JButton btJogar, btMenu, btTutorial, btSair, btPlacar;
	private JLabel versao, Plogo;
	protected static CardLayout card = new CardLayout();
	private JPanel jogar = new ModoDeJogo();

	ImageIcon logo = new ImageIcon("imagens/logo.png");
	ImageIcon jogo = new ImageIcon("imagens/jogar.png");
	ImageIcon opcoes = new ImageIcon("imagens/opcoes.png");
	ImageIcon tutorial = new ImageIcon("imagens/tutorial.png");
	ImageIcon sair = new ImageIcon("imagens/sair.png");
	ImageIcon placar = new ImageIcon("imagens/placar.png");
	
	//Animações
	ImageIcon jogarAnm = new ImageIcon("imagens/botao-jogar-animacao.png");
	ImageIcon opcoesAnm = new ImageIcon("imagens/botao-opcoes-animacao.png");
	ImageIcon placarAnm = new ImageIcon("imagens/botao-placar-animacao.png");
	ImageIcon tutorialAnm = new ImageIcon("imagens/botao-tutorial-animacao.png");
	ImageIcon sairAnm = new ImageIcon();
	
	
	ImageIcon fundoImg;
	JBackgroundPanel fundo;
	Som som;
	Efeito efeitos;

	public Menu() {
		super("Din Din");
		// configurando janela
		setLayout(null);
		setSize(1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// inicializando componentes
		btJogar = new JButton(jogo);
		btMenu = new JButton(opcoes);
		btTutorial = new JButton(tutorial);
		btSair = new JButton(sair);
		btPlacar = new JButton(placar);
		cLogo = new JPanel();
		contPrincipal = (JPanel) getContentPane();
		contPrincipal.setLayout(card);
		try {
			c = new JBackgroundPanel("imagens/fundo tela inicial 1.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		c.setBackground(new Color(66, 153, 206));
		c.setLayout(null);
		c.setName("MENU");

		// configurando componentes
		configuraLogo();
		configuraBtJogar();
		configurabtMenu();
		configurabtTutorial();
		configuraBtSair();
		configuraBtPlacar();
		animarBotoes();

		// adicionando componentes
		c.add(cLogo);
		configuraTelas();

		// tratando eventos
		trataEventos();

		// iniciando som e efeitos
		som = new Som();
		efeitos = new Efeito();
		
		//som.loop();

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
	public void configurabtMenu() {
		btMenu.setBounds(505, 460, 160, 70);
		btMenu.setContentAreaFilled(false);
		btMenu.setBorderPainted(false);
		c.add(btMenu);
	}

	// configura o botao de como Jogar (tutorial)
	public void configurabtTutorial() {
		btTutorial.setBounds(680, 460, 160, 70);
		btTutorial.setContentAreaFilled(false);
		btTutorial.setBorderPainted(false);
		c.add(btTutorial);
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

	public static void menu() {
		card.first(contPrincipal);
	}

	public void animarBotoes(){
				//outras animações
				btMenu.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btMenu.setIcon(opcoesAnm);
					}
					
					public void mouseReleased(MouseEvent e){
						btMenu.setIcon(opcoes);
					}
					
				});
				
				//outras animações
				btPlacar.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btPlacar.setIcon(placarAnm);
					}
					
					public void mouseReleased(MouseEvent e){
						btPlacar.setIcon(placar);
					}
					
				});
				
				//tutorial
				btTutorial.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btTutorial.setIcon(tutorialAnm);
					}
					
					public void mouseReleased(MouseEvent e){
						btTutorial.setIcon(tutorial);
					}
					
				});
				//tutorial
				btTutorial.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btTutorial.setIcon(tutorialAnm);
					}
					
					public void mouseReleased(MouseEvent e){
						btTutorial.setIcon(tutorial);
					}
					
				});
	}
	
	// tratando eventos
	public void trataEventos() {
		btSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConfirmaSair();
			}
		});
		
		//animação e mudança de tela
		btJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btJogar.setIcon(jogarAnm);
			}
			
			public void mouseReleased(MouseEvent e){
				mudaTela(jogar.getName());
				btJogar.setIcon(jogo);
				}
			
		});
		
		//outras animações
		btMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btMenu.setIcon(opcoesAnm);
			}
			
			public void mouseReleased(MouseEvent e){
				btMenu.setIcon(opcoes);
			}
			
		});

		btPlacar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Score();
			}
		});
		
		btSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btSair.setIcon(sairAnm);
			}
			
			public void mouseReleased(MouseEvent e){
				btSair.setIcon(sair);
			}
			
		});
		
		btTutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				efeitos.clicar();
			}
			
		});
		
		//eventos
		btMenu.addActionListener(new ActionListener() {
			int contador = 0, contador2 = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// modo Psicopata ativado!

				JFrame f = new JFrame("OPCOES");
				f.setSize(250, 100);
				f.setLayout(new FlowLayout());
				f.setLocationRelativeTo(null);

				JButton btMusica = new JButton("MUTAR MUSICA");
				JButton btEfeitos = new JButton("MUTAR EFEITOS");
				f.add(btMusica);
				f.add(btEfeitos);
				versao = new JLabel("Versao Alpha.");
				f.add(versao);

				btMusica.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (contador % 2 == 0) {
							som.parar();
							btMusica.setText("TOCAR MUSICA");
							System.out.println("Som mutado");
						} else {
							btMusica.setText("MUTAR MUSICA");
							som.loop();
							System.out.println("Som tocando");
						}
						contador++;
					}
				});
				
				btEfeitos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (contador2 % 2 == 0) {
							efeitos.comEfeito();
							btMusica.setText("TOCAR EFEITOS");
							System.out.println("Som mutado");
						} else {
							btMusica.setText("MUTAR EFEITOS");
							efeitos.semEfeito();
							System.out.println("Som tocando");
						}
						contador2++;
					}
				});

				f.setVisible(true);
			}

		});
	}

	public static void main(String[] args) {
		new Menu();
	}
}
