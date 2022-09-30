package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jogadores extends JPanel {
	// instanciação das coisinhas
	private JTextField tfLilas, tfRosa, tfVerde, tfAmarelo, tfVermelho,
			tfLaranja;
	private JBackgroundPanel panelLilas, panelAmarelo, panelVermelho, panelLaranja, panelVerde, panelRosa;
	private JLabel lbTituloJogadores;
	private JButton panelVoltar, btJogar;
	private int contX = 0, contY = 0;
	private static String nome = "JOGADORES";
	private JPanel modoFacil = new ModoFacil(),
			modoDificil = new ModoDificil();

	// imagens
	private ImageIcon imgTitulo = new ImageIcon(getClass().getResource(
			"Jogadores.png")), imgJogar = new ImageIcon(getClass().getResource(
			"jogar2.png")), imgVoltar = new ImageIcon(getClass().getResource(
			"botao voltar.png"));
	private JPanel panelJogadores;

	// construtor da classe
	public Jogadores() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		lbTituloJogadores = new JLabel(imgTitulo);
		btJogar = new JButton(imgJogar);
		try {
			panelLilas = new JBackgroundPanel(getClass().getResource("jogador lilás.png"));
			panelAmarelo = new JBackgroundPanel(getClass().getResource("jogador amarelo.png"));
			panelRosa = new JBackgroundPanel(getClass().getResource("jogador rosa.png"));
			panelVerde = new JBackgroundPanel(getClass().getResource("jogador verde.png"));
			panelVermelho = new JBackgroundPanel(getClass().getResource("jogador vermelho.png"));
			panelLaranja = new JBackgroundPanel(getClass().getResource("jogador laranja.png"));
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

	/** configurando o botão de voltar */
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
		panelJogadores.setBounds(233, 150, 900, 550);
		panelJogadores.setLayout(null);

		panelJogadores.add(panelLilas);
		panelLilas.setOpaque(false);
		panelLilas.setBounds(0, 0, 400, 150);
		tfLilas = new JTextField();
		tfLilas.setBounds(100,63,286,32);
		panelLilas.add(tfLilas);

		int aumentaX = 500;
		int aumentaY = 200;
		int posicaoX = 100;
		int posicaoY= 63;
		int larguraTxt = 286;
		int alturaTxt = 32;
		
		panelRosa.setBounds(panelLilas.getX(), panelLilas.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelRosa.setOpaque(false);
		tfRosa = new JTextField();
		tfRosa.setBounds(posicaoX,posicaoY,larguraTxt,alturaTxt);
		panelRosa.add(tfRosa);
		panelJogadores.add(panelRosa);

		
		panelVerde.setBounds(panelLilas.getX(), panelRosa.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelVerde.setOpaque(false);
		tfVerde = new JTextField();
		tfVerde.setBounds(posicaoX,posicaoY,larguraTxt,alturaTxt);
		panelVerde.add(tfVerde);
		panelJogadores.add(panelVerde);

		
		panelAmarelo.setBounds(panelLilas.getX() + aumentaX, panelLilas.getY(), panelLilas.getWidth(), panelLilas.getHeight());
		panelAmarelo.setOpaque(false);
		tfAmarelo = new JTextField();
		tfAmarelo.setBounds(posicaoX,posicaoY,larguraTxt,alturaTxt);
		panelAmarelo.add(tfAmarelo);
		panelJogadores.add(panelAmarelo);

		
		panelVermelho.setBounds(panelRosa.getX() + aumentaX, panelRosa.getY(), panelLilas.getWidth(), panelLilas.getHeight());
		panelVermelho.setOpaque(false);
		tfVermelho = new JTextField();
		tfVermelho.setBounds(posicaoX,posicaoY,larguraTxt,alturaTxt);
		panelVermelho.add(tfVermelho);
		panelJogadores.add(panelVermelho);

		
		panelLaranja.setBounds(panelVerde.getX() + aumentaX, panelVerde.getY(), panelLilas.getWidth(), panelLilas.getHeight());
		panelLaranja.setOpaque(false);
		tfLaranja = new JTextField();
		tfLaranja.setBounds(posicaoX,posicaoY,larguraTxt,alturaTxt);
		panelLaranja.add(tfLaranja);
		panelJogadores.add(panelLaranja);

		add(panelJogadores);
	}

	/**há um bug aqui, só está indo para a tela do Modo Facil*/
	public void configuraBtJogar() {
		add(btJogar);
		btJogar.setLayout(null);
		btJogar.setBounds(1200, 640, 150, 60);
		btJogar.setContentAreaFilled(false);
		btJogar.setBorderPainted(false);

		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (contY==0) {
					Menu.adicionaTela(modoFacil, modoFacil.getName());
					Menu.mudaTela(modoFacil.getName());
				} else if(contX==0){
					Menu.adicionaTela(modoDificil, modoDificil.getName());
					Menu.mudaTela(modoDificil.getName());
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
