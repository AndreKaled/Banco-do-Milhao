package view;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.JogadorController;
import modelo.Jogador;

public class Score extends JBackgroundPanel {

	JPanel container, f;
	JScrollPane scroll;
	JLabel estrela, trofeu, controle, nickname;
	JLabel[] nome, score, vitorias, partidas;
	JBackgroundPanel bandeira, painel;
	ImageIcon imgSair, imgNickname, imgControle, imgTrofeu, imgEstrela;
	JButton btSair;
	Color corFont;

	public Score() throws IOException {
		super("imagens/area-menu.png");
		setLayout(null);
		setBounds(0, 0, 800, 700);
		setOpaque(false);

		try {
			configura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setVisible(true);
	}

	public void configura() throws IOException {

		bandeira = new JBackgroundPanel("imagens/bandeirolaRoxa.png");
		bandeira.setOpaque(false);
		bandeira.setBounds(150, 150, getWidth() - 300, 70);

		add(bandeira);

		// botar imagem no botao aqui
		imgSair = new ImageIcon("Imagens/botaoFechar.png");
		btSair = new JButton(imgSair);
		btSair.setBounds(400, 10, 50, 50);
		bandeira.add(btSair);

		configContainer();
	}

	public void configContainer() {
		container = new JPanel();
		container.setLayout(null);

		imgNickname = new ImageIcon("Imagens/Nickname.png");
		imgEstrela = new ImageIcon("Imagens/estrela-placar2 1.png");
		imgControle = new ImageIcon("Imagens/video-game 2.png");
		imgTrofeu = new ImageIcon("Imagens/trofeu-placar-3 1.png");

		nickname = new JLabel(imgNickname);
		estrela = new JLabel(imgEstrela);
		trofeu = new JLabel(imgTrofeu);
		controle = new JLabel(imgControle);

		nickname.setBounds(0, 10, 150, 50);
		estrela.setBounds(nickname.getX() + nickname.getWidth() + 30, 15, 50, 70);
		trofeu.setBounds(estrela.getX() + estrela.getWidth() + 30, estrela.getY() - 15, estrela.getWidth(),
				estrela.getHeight());
		controle.setBounds(trofeu.getX() + trofeu.getWidth() + 30, trofeu.getY(), trofeu.getWidth(),
				trofeu.getHeight());

		container.add(nickname);
		container.add(estrela);
		container.add(trofeu);
		container.add(controle);

		corFont = new Color(125,73,12);
		
		try {
			pesquisaScore();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scroll = new JScrollPane(container);
		scroll.setBounds(bandeira.getX() + 40, bandeira.getY() + 80, 420, 380);
		container.setBackground(new Color(250,240,206));
		scroll.setBorder(null);
		
		add(scroll);
	}

	public void pesquisaScore() throws SQLException {
		
		ArrayList<Jogador> j = new JogadorController().jogadoresExistentes();
		// variaveis de teste
		int init = nickname.getX() + nickname.getHeight();

		int tam = j.size();
		
		container.setPreferredSize(new Dimension(400, tam * 29));
		
		nome = new JLabel[tam];
		score = new JLabel[tam];
		vitorias = new JLabel[tam];
		partidas = new JLabel[tam];

		int i = 0;
		for (Jogador jogador: j) {
			nome[i] = new JLabel(jogador.getNickName());
			score[i] = new JLabel("" +jogador.getScore());
			vitorias[i] = new JLabel("" +jogador.getVitorias());
			partidas[i] = new JLabel("" +jogador.getPartidasJogadas());

			nome[i].setBounds(0, init + 10, 150, 25);
			score[i].setBounds(estrela.getX(), init + 10, 150, 25);
			vitorias[i].setBounds(trofeu.getX(), init + 10, 150, 25);
			partidas[i].setBounds(controle.getX(), init + 10, 150, 25);

			nome[i].setForeground(corFont);
			score[i].setForeground(corFont);
			vitorias[i].setForeground(corFont);
			partidas[i].setForeground(corFont);
			
			container.add(nome[i]);
			container.add(score[i]);
			container.add(vitorias[i]);
			container.add(partidas[i]);

			init += 25;
			i++;
		}
	}

}
