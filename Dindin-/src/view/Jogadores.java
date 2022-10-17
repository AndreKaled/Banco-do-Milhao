package view;

/**a
 * Andre Kaled Duarte Coutinho - 30/09/2022
 * Graziela da Costa Ralph - 29/09/2022
 * Kauan Ferreira dos Santos - 29/09/2022
 * 
 * Tela onde o sao contabilizados a quantidade e o nome
 * dos jogadores, armazenando o nome no banco de dados e
 * atualizando o score do jogador quando vencer o jogo
 * */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Jogador;
import Banco.Banco;

public class Jogadores extends JPanel {
	// instanciando as coisinhas
	private JTextField tfLilas, tfRosa, tfVerde, tfAmarelo, tfVermelho,
			tfLaranja;
	private JBackgroundPanel panelLilas, panelAmarelo, panelVermelho,
			panelLaranja, panelVerde, panelRosa;
	private JLabel lbTituloJogadores;
	private JButton panelVoltar, btJogar;
	private int contX = 0, contY = 0;
	private static String nome = "JOGADORES";
	private JPanel modoFacil = new ModoFacil(),
			modoDificil = new ModoDificil();

	int contLilas = 0, contVerde = 0, contVermelho = 0, contAmarelo = 0,
			contLaranja = 0, contRosa = 0;
	// imagens
	private ImageIcon imgTitulo = new ImageIcon("Imagens/Jogadores.png"),
			imgJogar = new ImageIcon("Imagens/jogar2.png"),
			imgVoltar = new ImageIcon("Imagens/botao voltar.png");
	private JPanel panelJogadores;

	// construtor da classe
	public Jogadores() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		lbTituloJogadores = new JLabel(imgTitulo);
		btJogar = new JButton(imgJogar);
		try {
			panelLilas = new JBackgroundPanel("imagens/jogador lilas.png");
			panelAmarelo = new JBackgroundPanel("imagens/jogador amarelo.png");
			panelRosa = new JBackgroundPanel("imagens/jogador rosa.png");
			panelVerde = new JBackgroundPanel("imagens/jogador verde.png");
			panelVermelho = new JBackgroundPanel("imagens/jogador vermelho.png");
			panelLaranja = new JBackgroundPanel("imagens/jogador laranja.png");
		} catch (Exception e) {
			System.err.println("Erro ao carregar alguma imagem!");
			e.printStackTrace();
		}

		configuraBtVoltar();
		configurapanel();
		configuraBtJogar();
		configuraTitulo();

		setName(nome);

	}

	/** configurando o botao de voltar */
	private void configuraBtVoltar() {
		panelVoltar = new JButton(imgVoltar);
		add(panelVoltar);
		panelVoltar.setBounds(10, 10, 70, 70);
		panelVoltar.setContentAreaFilled(false);
		panelVoltar.setBorderPainted(false);
		panelVoltar.setFocusable(false);

		panelVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.mudaTela(ModoDeJogo.getNome());
				tfLilas.setText("Digite seu nome...");
				tfRosa.setText("Digite seu nome...");
				tfVerde.setText("Digite seu nome...");
				tfLaranja.setText("Digite seu nome...");
				tfAmarelo.setText("Digite seu nome...");
				tfVermelho.setText("Digite seu nome...");
			}

		});
	}

	/** configurando titulo da tela */
	private void configuraTitulo() {
		lbTituloJogadores.setBounds(418, 10, 530, 100);
		add(lbTituloJogadores);
	}

	/** configurando paineis de jogadores */
	public void configurapanel() {
		panelJogadores = new JPanel();
		panelJogadores.setOpaque(false);
		panelJogadores.setBounds(260, 150, 845, 480);
		panelJogadores.setLayout(null);

		panelJogadores.add(panelLilas);
		panelLilas.setOpaque(false);
		panelLilas.setBounds(0, 0, 370, 120);
		int aumentaX = 475;
		int aumentaY = 175;
		int posicaoX = panelLilas.getX() + 90;
		int posicaoY = panelLilas.getY() + 50;
		int larguraTxt = 270;
		int alturaTxt = 32;

		tfLilas = new JTextField();
		tfLilas.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelLilas.add(tfLilas);

		panelRosa.setBounds(panelLilas.getX(), panelLilas.getY() + aumentaY,
				panelLilas.getWidth(), panelLilas.getHeight());
		panelRosa.setOpaque(false);
		tfRosa = new JTextField();
		tfRosa.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelRosa.add(tfRosa);
		panelJogadores.add(panelRosa);

		panelVerde.setBounds(panelLilas.getX(), panelRosa.getY() + aumentaY,
				panelLilas.getWidth(), panelLilas.getHeight());
		panelVerde.setOpaque(false);
		tfVerde = new JTextField();
		tfVerde.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelVerde.add(tfVerde);
		panelJogadores.add(panelVerde);

		panelAmarelo.setBounds(panelLilas.getX() + aumentaX, panelLilas.getY(),
				panelLilas.getWidth(), panelLilas.getHeight());
		panelAmarelo.setOpaque(false);
		tfAmarelo = new JTextField();
		tfAmarelo.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelAmarelo.add(tfAmarelo);
		panelJogadores.add(panelAmarelo);

		panelVermelho.setBounds(panelRosa.getX() + aumentaX, panelRosa.getY(),
				panelLilas.getWidth(), panelLilas.getHeight());
		panelVermelho.setOpaque(false);
		tfVermelho = new JTextField();
		tfVermelho.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelVermelho.add(tfVermelho);
		panelJogadores.add(panelVermelho);

		panelLaranja.setBounds(panelVerde.getX() + aumentaX, panelVerde.getY(),
				panelLilas.getWidth(), panelLilas.getHeight());
		panelLaranja.setOpaque(false);
		tfLaranja = new JTextField();
		tfLaranja.setBounds(posicaoX, posicaoY, larguraTxt, alturaTxt);
		panelLaranja.add(tfLaranja);
		panelJogadores.add(panelLaranja);

		add(panelJogadores);
		configuraFonte();
		configuraInicio();
	}

	private void configuraFonte() {
		Font fonte = new Font("Arial", 0, 20);
		tfLilas.setFont(fonte);
		tfRosa.setFont(fonte);
		tfVerde.setFont(fonte);
		tfLaranja.setFont(fonte);
		tfAmarelo.setFont(fonte);
		tfVermelho.setFont(fonte);
	}

	private void configuraInicio() {
		tfLilas.setToolTipText("Digite seu nome...");
		tfRosa.setToolTipText("Digite seu nome...");
		tfVerde.setToolTipText("Digite seu nome...");
		tfLaranja.setToolTipText("Digite seu nome...");
		tfAmarelo.setToolTipText("Digite seu nome...");
		tfVermelho.setToolTipText("Digite seu nome...");

		tfLilas.setText("Digite seu nome...");
		tfRosa.setText("Digite seu nome...");
		tfVerde.setText("Digite seu nome...");
		tfLaranja.setText("Digite seu nome...");
		tfAmarelo.setText("Digite seu nome...");
		tfVermelho.setText("Digite seu nome...");

		// configurando cores e tirando borda
		Color proFundo = new Color(237, 237, 237);
		tfLilas.setBackground(proFundo);
		tfLilas.setBorder(null);
		tfRosa.setBackground(proFundo);
		tfRosa.setBorder(null);
		tfVerde.setBackground(proFundo);
		tfVerde.setBorder(null);
		tfLaranja.setBackground(proFundo);
		tfLaranja.setBorder(null);
		tfAmarelo.setBackground(proFundo);
		tfAmarelo.setBorder(null);
		tfVermelho.setBackground(proFundo);
		tfVermelho.setBorder(null);

		// fazendo com que quando clicar 1 vez no texto deixe a caixa nula.
		tfLilas.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contLilas == 0) {
					contLilas++;
					tfLilas.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		tfVerde.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contVerde == 0) {
					contVerde++;
					tfVerde.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		tfRosa.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contRosa == 0) {
					contRosa++;
					tfRosa.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		tfLaranja.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contLaranja == 0) {
					contLaranja++;
					tfLaranja.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		tfVermelho.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contVermelho == 0) {
					contVermelho++;
					tfVermelho.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		tfAmarelo.addMouseListener(new MouseListener() {

			// default
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			// default
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			// default
			public void mouseExited(MouseEvent arg0) {
			}

			// tornando a caixa vazia quando clicado pela 1ï¿½ vez
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (contAmarelo == 0) {
					contAmarelo++;
					tfAmarelo.setText("");
				}
			}

			// default
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
	}

	/** ha um bug aqui, sï¿½ estï¿½ indo para a tela do Modo Facil */
	public void configuraBtJogar() {
		add(btJogar);
		btJogar.setLayout(null);
		btJogar.setBounds(1150, 620, 150, 60);
		btJogar.setContentAreaFilled(false);
		btJogar.setBorderPainted(false);

		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (contY == 0) {
					Menu.adicionaTela(modoFacil, modoFacil.getName());
					Menu.mudaTela(modoFacil.getName());
				} else if (contX == 0) {
					Menu.adicionaTela(modoDificil, modoDificil.getName());
					Menu.mudaTela(modoDificil.getName());
				}
				
				// verificando jogador no banco, se nao houver adiciona na
				// tabela de Jogadores no banco de dados
				//roxo
				if (!(tfLilas.getText().equals("")||tfLilas.getText().equals("Digite seu nome..."))){
					Jogador jogador = new Jogador(tfLilas.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
				//texto do jogador rosa
				if (!(tfRosa.getText().equals("")||tfRosa.getText().equals("Digite seu nome..."))) {
					Jogador jogador = new Jogador(tfRosa.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
				
				//texto do jogador verde
				if (!(tfVerde.getText().equals("")||tfVerde.getText().equals("Digite seu nome..."))) {
					Jogador jogador = new Jogador(tfVerde.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
				
				//texto do jogador amarelo
				if (!(tfAmarelo.getText().equals("")||tfAmarelo.getText().equals("Digite seu nome..."))) {
					Jogador jogador = new Jogador(tfAmarelo.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
				
				//texto do jogador vermelho
				if (!(tfVermelho.getText().equals("")||tfVermelho.getText().equals("Digite seu nome..."))) {
					Jogador jogador = new Jogador(tfVermelho.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
				
				//texto do jogador laranja
				if (!(tfLaranja.getText().equals("")||tfLaranja.getText().equals("Digite seu nome..."))) {
					Jogador jogador = new Jogador(tfLaranja.getText());
					System.out.println(Banco.verificaJogador(jogador));
					if(Banco.verificaJogador(jogador)){
						System.out.println("Jogador existente!");
					}else{
						Banco.novoJogador(jogador);
						System.out.println("Novo jogador adicionado!");
					}
				}
			}

		});
	}

	// metodos de acesso
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
