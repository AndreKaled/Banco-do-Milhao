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
	private JTextField TfLilás, TfRosa, TfVerde, TfAmarelo, TfVermelho,
			TfLaranja;
	private JLabel panelLilas, panelRosa, panelVerde, panelAmarelo,
			panelVermelho, panelLaranja;
	private JLabel lbTituloJogadores;
	private JButton panelVoltar, btJogar;
	private int contX = 0, contY = 0;
	private static String nome = "JOGADORES";
	private JPanel modoFacil = new ModoFacil(),
			modoDificil = new ModoDificil(), panelJogadores;

	// imagens
	private ImageIcon imgTitulo = new ImageIcon(getClass().getResource(
			"Jogadores.png")), imgLilas = new ImageIcon(getClass().getResource(
			"jogador lilás.png")), imgJogar = new ImageIcon(getClass()
			.getResource("jogar2.png")), imgVoltar = new ImageIcon(getClass()
			.getResource("botao voltar.png"));

	// construtor da classe
	public Jogadores() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		lbTituloJogadores = new JLabel(imgTitulo);
		panelLilas = new JLabel(imgLilas);

		btJogar = new JButton(imgJogar);

		configuraBtVoltar();
		configuraPanel();
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

		panelVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.mudaTela(ModoDeJogo.getNome());
			}

		});
	}

	// configurando titulo da tela
	private void configuraTitulo() {
		lbTituloJogadores.setBounds(418, 10, 530, 100);
		add(lbTituloJogadores);
	}

	// configurando painel e label para a entrada de dados do NickName
	public void configuraPanel() {
		panelJogadores = new JPanel();
		panelJogadores.setBounds(200, 150, 900, 550);
		panelJogadores.setLayout(null);

		panelJogadores.add(panelLilas);
		panelLilas.setBounds(0, 0, 400, 150);

		aumentaX = 500;
		aumentaY = 200;
		panelRosa = new JLabel(imgLilas);
		panelRosa.setBounds(panelLilas.getX(), panelLilas.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelJogadores.add(panelRosa);

		panelVerde = new JLabel(imgLilas);
		panelVerde.setBounds(panelLilas.getX(), panelRosa.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelJogadores.add(panelVerde);

		panelAmarelo = new JLabel(imgLilas);
		panelAmarelo.setBounds(panelLilas.getX() + aumentaX, panelLilas.getY(), panelLilas.getWidth(), panelLilas.getHeight());
		panelJogadores.add(panelAmarelo);

		panelVermelho = new JLabel(imgLilas);
		panelVermelho.setBounds(panelRosa.getX() + aumentaX, panelRosa.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelJogadores.add(panelVermelho);

		panelLaranja = new JLabel(imgLilas);
		panelLaranja.setBounds(panelVerde.getX() + aumentaX, panelVerde.getY() + aumentaY, panelLilas.getWidth(), panelLilas.getHeight());
		panelJogadores.add(panelLaranja);

		add(panelJogadores);
	}

	public void configuraBtJogar() {
		add(btJogar);
		btJogar.setLayout(null);
		btJogar.setBounds(1150, 640, 150, 70);
		btJogar.setContentAreaFilled(false);
		btJogar.setBorderPainted(false);

		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ModoDeJogo.getOpcao() == modoFacil.getName()) {
					if (contY == 0) {
						contY++;
						Menu.adicionaTela(modoFacil, modoFacil.getName());
					}
					Menu.mudaTela(modoFacil.getName());
				} else {
					if (contX == 0) {
						contX++;
						Menu.adicionaTela(modoDificil, modoDificil.getName());
					}
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
