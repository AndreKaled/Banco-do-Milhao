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

	private static JPanel c, cLogo, contPrincipal, janela;
	private JButton btJogar, btMenu, btTutorial, btSair, btPlacar;
	private JLabel  Plogo;
	protected static CardLayout card = new CardLayout();
	private JPanel jogar = new ModoDeJogo();
	ConfirmaSair cs;

	ImageIcon logo = new ImageIcon("imagens/logo.png");
	ImageIcon jogo = new ImageIcon("imagens/jogar.png");
	ImageIcon opcoes = new ImageIcon("imagens/opcoes.png");
	ImageIcon tutorial = new ImageIcon("imagens/tutorial.png");
	ImageIcon sair = new ImageIcon("imagens/sair.png");
	ImageIcon placar = new ImageIcon("imagens/placar.png");

	// Animacoes
	ImageIcon jogarAnm = new ImageIcon("imagens/botao-jogar-animacao.png");
	ImageIcon opcoesAnm = new ImageIcon("imagens/botao-opcoes-animacao.png");
	ImageIcon placarAnm = new ImageIcon("imagens/botao-placar-animacao.png");
	ImageIcon tutorialAnm = new ImageIcon("imagens/botao-tutorial-animacao.png");
	ImageIcon sairAnm = new ImageIcon();
	ImageIcon imgEfeitosBloq = new ImageIcon("Imagens/botaoDosEfeitosBloq.png");
	ImageIcon imgMusicaBloq = new ImageIcon("Imagens/botaoDaMusicaBloq.png");
	ImageIcon imgMusica = new ImageIcon("Imagens/botao-da-musica.png"),
			imgEfeitos = new ImageIcon("Imagens/botao-dos-efeitos.png"),
			imgFecha = new ImageIcon("Imagens/botao-fechar-1.png"),
			imgCredito = new ImageIcon("Imagens/botao creditos.png");

	JButton btMusica = new JButton(imgMusica);
	JButton btEfeitos = new JButton(imgEfeitos);
	JButton btFechar = new JButton(imgFecha);
	JButton btCredito = new JButton(imgCredito);
	JLabel versao = new JLabel("Versao Alpha lindos");

	ImageIcon fundoImg;
	JBackgroundPanel fundo, opcoesPanel;
	Som som;
	Efeito efeitos;
	
	int contador = 0;
	int contador2 = 0;
	int contEfeito = 0;

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
		janela = new JPanel();
		try {
			c = new JBackgroundPanel("imagens/fundo tela inicial 1.png");
			opcoesPanel = new JBackgroundPanel("imagens/fundo-opcoes-1.png");
			cs = new ConfirmaSair("imagens/fundo-confirmar-saida.png");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cs.setBounds(383, 109, 600, 550);
		opcoesPanel.setBounds(cs.getBounds());

		c.setBackground(new Color(66, 153, 206));
		c.setLayout(null);
		c.setName("MENU");
		janela.setBounds(0, 0, 1366, 768);
		c.add(janela);
		janela.setOpaque(false);
		janela.setLayout(null);

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

		
		som.loop();
		janela.add(cs);
		janela.add(opcoesPanel);
		opcoesPanel.setVisible(false);

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

	public void animarBotoes() {
		// outras animacoes
		btMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btMenu.setIcon(opcoesAnm);
			}

			public void mouseReleased(MouseEvent e) {
				btMenu.setIcon(opcoes);
				efeitos.clicar();
			}

		});

		// placar
		btPlacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btPlacar.setIcon(placarAnm);
			}

			public void mouseReleased(MouseEvent e) {
				btPlacar.setIcon(placar);
				efeitos.clicar();
			}

		});

		// tutorial
		btTutorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btTutorial.setIcon(tutorialAnm);
			}

			public void mouseReleased(MouseEvent e) {
				btTutorial.setIcon(tutorial);
				efeitos.clicar();
			}

		});

		// jogar
		btJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btJogar.setIcon(jogarAnm);
			}

			public void mouseReleased(MouseEvent e) {
				btJogar.setIcon(jogo);
				efeitos.clicar();
			}
		});

		btSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btSair.setIcon(sairAnm);
			}

			public void mouseReleased(MouseEvent e) {
				btSair.setIcon(sair);
				efeitos.clicar();
			}

		});
		
		
		
		btEfeitos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(contEfeito % 2 == 0) {
					btEfeitos.setIcon(imgEfeitosBloq);
					System.out.println("Efeitos desativados");
					efeitos.semEfeito();
				}else {
					btEfeitos.setIcon(imgEfeitos);
					System.out.println("Efeitos ativados");
					efeitos.comEfeito();
				}
				efeitos.clicar();
				contEfeito++;
			}

		});
		
		btMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador % 2 == 0) {
					som.parar();
					System.out.println("Musica desativado");
					btMusica.setIcon(imgMusicaBloq);
				} else {
					som.loop();
					System.out.println("Som tocando");
					btMusica.setIcon(imgMusica);
				}
				contador++;
			}
		});
	}

	// tratando eventos
	public void trataEventos() {

		criaMenu();
		criaSair();
		
		// bug aqui
		btSair.addActionListener(new ActionListener() {
			private int cont = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cs.setVisible(true);
				repaint();
			}
		});

		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mudaTela(jogar.getName());
			}

		});

		btPlacar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btJogar.setEnabled(false);
					btMenu.setEnabled(false);
					btTutorial.setEnabled(false);
					btSair.setEnabled(false);
					btPlacar.setEnabled(false);
					
					Score s = new Score();
					janela.add(s);
					
					s.btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							s.setVisible(false);
							btJogar.setEnabled(true);
							btMenu.setEnabled(true);
							btTutorial.setEnabled(true);
							btSair.setEnabled(true);
							btPlacar.setEnabled(true);
						}});
					repaint();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btTutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}

		});

		// configuracoes
		btMenu.addActionListener(new ActionListener() {
			int contador = 0, contador2 = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// modo Psicopata ativado!
				btJogar.setEnabled(false);
				btMenu.setEnabled(false);
				btTutorial.setEnabled(false);
				btSair.setEnabled(false);
				btPlacar.setEnabled(false);
				opcoesPanel.setVisible(true);
			}

		});
	}

	;

	private void criaSair() {
		// TODO Auto-generated method stub
		try {
			cs = new ConfirmaSair("imagens/fundo-confirmar-saida.png");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		janela.add(cs);
		cs.setBounds(383, 109, 600, 550);
	}

	private void criaMenu() {
		// TODO Auto-generated method stub
		

		try {
			JBackgroundPanel bandeira = new JBackgroundPanel("imagens/bandeirola.png");
			bandeira.setOpaque(false);
			
			bandeira.setBounds(0, 120, 600, 50);
			btFechar.setBounds(550, 10, 30, 30);
			bandeira.setLayout(null);
			bandeira.add(btFechar);
			opcoesPanel.add(bandeira);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		opcoesPanel.setLayout(null);
		opcoesPanel.setOpaque(false);

		versao.setBounds(350, 280, 250, 60);
		btCredito.setBounds(300, 180, 250, 80);
		btEfeitos.setBounds(30, 300, 250, 60);
		btMusica.setBounds(30, 180, 250, 60);
		
		btCredito.setBorder(null);
		btEfeitos.setBorder(null);
		btMusica.setBorder(null);
		btCredito.setContentAreaFilled(false);
		btEfeitos.setContentAreaFilled(false);
		btMusica.setContentAreaFilled(false);
		btCredito.setFocusable(false);
		btEfeitos.setFocusable(false);
		btMusica.setFocusable(false);
		
		opcoesPanel.add(btCredito);
		opcoesPanel.add(versao);
		opcoesPanel.add(btEfeitos);
		opcoesPanel.add(btMusica);

		btFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				opcoesPanel.setVisible(false);
				btJogar.setEnabled(true);
				btMenu.setEnabled(true);
				btTutorial.setEnabled(true);
				btSair.setEnabled(true);
				btPlacar.setEnabled(true);
			}
		});

		btCredito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Creditos();
			}});

	}

	public static void main(String[] args) {
		new Menu();
	}
}
