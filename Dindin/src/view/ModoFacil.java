package view;

/**Andr� Kaled Duarte - 30/09/2022
 * Sarah Pinheiro Antunes - 29/09/2022
 * Graziela da Costa Ralph - 16/10/2022
 * Sarah Pinheiro Antunes - 17/10/2022
 * Graziela da Costa Ralph - 17/10/2022
 * 
 * Modo facil
 * essa classe deve ser um dos modos de jogo escolhido pelo usu�rio, as configur��es do jogo s�o
 * definidas para iniciantes por�m a interface continua a mesma, aqui � onde ser� a area principal do jogo pois
 * � onde os jogadores passar�o mais tempo.
 * 
 * Dado? ok
 * Vez do jogador a mostra? ok
 * Tabuleiro? X
 * Conectado posi��o do personagem? X
 * Lista de compras do Jogador? X
 * */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Dado;

public class ModoFacil extends JPanel {

	private JPanel areaDado, painelVez;
	private JButton btRolar, btVoltar, btLista, btMenu;
	private JLabel resultado1, resultado2, resultado3, resultado4, resultado5,
			resultado6, areaVez, moeda, quantMoeda, personagem, nome;
	private int rolaDado = 0, dadoAntigo = 0;
	ImageIcon imgFundo = new ImageIcon("Imagens/area-jogador-da-vez.png"),
			imgLista = new ImageIcon("Imagens/imagens/botao lista.png"),
			imgMoeda = new ImageIcon("Imagens/moeda-java.png"),
			imgPersonagem = new ImageIcon("Imagens/personagem.png"),
			imgNome = new ImageIcon("Imagens/nome.png"),
			imgMenu = new ImageIcon("Imagens/botao-menu.png"),
			imgRolar = new ImageIcon("Imagens/botao-rola-dado.png"),
			imgDado1 = new ImageIcon("Imagens/Dado-1.png"),
			imgDado2 = new ImageIcon("Imagens/Dado-2.png"),
			imgDado3 = new ImageIcon("Imagens/Dado-3.png"),
			imgDado4 = new ImageIcon("Imagens/Dado-4.png"),
			imgDado5 = new ImageIcon("Imagens/Dado-5.png"),
			imgDado6 = new ImageIcon("Imagens/Dad-6.png");

	public ModoFacil() {
		setLayout(null);
		setBackground(new Color(200, 133, 238));
		setName("MODO FACIL");
		areaDado = new JPanel();
		btRolar = new JButton(imgRolar);
		btVoltar = new JButton("VOLTAR");
		resultado1 = new JLabel(imgDado1);
		resultado2 = new JLabel(imgDado2);
		resultado3 = new JLabel(imgDado3);
		resultado4 = new JLabel(imgDado4);
		resultado5 = new JLabel(imgDado5);
		resultado6 = new JLabel(imgDado6);
		btMenu = new JButton(imgMenu);

		configuraDado();
		configuraBtVoltar();
		configuraVez();
		configuraBtMenu();
	}

	// configurando a aba de ver a vez do jogador
	private void configuraVez() {
		painelVez = new JPanel();
		painelVez.setLayout(null);
		painelVez.setBounds(508, 550, 350, 200);
		add(painelVez);
		painelVez.setOpaque(false);

		areaVez = new JLabel(imgFundo);
		// areaVez.setOpaque(true);
		areaVez.setBounds(painelVez.getBounds());

		btLista = new JButton(imgLista);
		btLista.setBorderPainted(false);
		btLista.setFocusable(false);
		btLista.setContentAreaFilled(false);
		btLista.setBounds(100, 40, 62, 62);

		moeda = new JLabel(imgMoeda);
		moeda.setBounds(150, 40, 70, 70);

		personagem = new JLabel(imgPersonagem);
		personagem.setBounds(7, 10, 100, 100);

		nome = new JLabel(imgNome);
		nome.setBounds(110, -70, 200, 200);

		quantMoeda = new JLabel("XXX,XX");
		int x = moeda.getX();
		int y = moeda.getY();
		int w = moeda.getWidth();
		int h = moeda.getHeight();
		quantMoeda.setBounds(x + 60, y + 20, w, h - 50);
		// quantMoeda.setFont(font);

		add(areaVez);
		painelVez.add(btLista);
		painelVez.add(moeda);
		painelVez.add(quantMoeda);
		painelVez.add(personagem);
		painelVez.add(nome);
	}

	// configurando area do Dado
	private void configuraDado() {

		// config para o painel
		areaDado.setLayout(null);
		areaDado.setOpaque(false);

		// adicionando os componentes
		areaDado.add(resultado1);
		areaDado.add(resultado2);
		areaDado.add(resultado3);
		areaDado.add(resultado4);
		areaDado.add(resultado5);
		areaDado.add(resultado6);
		areaDado.add(btRolar);
		add(areaDado);

		// posicionamento e tamanho
		btRolar.setBounds(30, 200, 150, 150);
		resultado1.setBounds(-100, -70, 400, 500);
		resultado2.setBounds(-100, -70, 400, 500);
		resultado3.setBounds(-100, -70, 400, 500);
		resultado4.setBounds(-100, -70, 400, 500);
		resultado5.setBounds(-100, -70, 400, 500);
		resultado6.setBounds(-100, -70, 400, 500);
		areaDado.setBounds(1000, 350, 200, 400);

		// bagulhin do setvisible
		resultado1.setVisible(true);
		resultado2.setVisible(false);
		resultado3.setVisible(false);
		resultado4.setVisible(false);
		resultado5.setVisible(false);
		resultado6.setVisible(false);

		// configuraçao do botao rolar dado
		btRolar.setContentAreaFilled(false);
		btRolar.setBorderPainted(false);

		/*
		 * resultado.setFont(new Font("Arial", 1, 19));
		 * resultado.setForeground(Color.ORANGE); btRolar.setFont(new
		 * Font("Arial", 1, 14));
		 */

		btRolar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rolaDado = Dado.rolar();
				switch (rolaDado) {
				case 1:
					switch (dadoAntigo) {
					case 1:
						break;
					case 2:
						resultado2.setVisible(false);
						break;
					case 3:
						resultado3.setVisible(false);
						break;
					case 4:
						resultado4.setVisible(false);
						break;
					case 5:
						resultado5.setVisible(false);
						break;
					case 6:
						resultado6.setVisible(false);
						break;
					}
					resultado1.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				case 2:
					switch (dadoAntigo) {
					case 1:
						resultado1.setVisible(false);
						break;
					case 2:
						break;
					case 3:
						resultado3.setVisible(false);
						break;
					case 4:
						resultado4.setVisible(false);
						break;
					case 5:
						resultado5.setVisible(false);
						break;
					case 6:
						resultado6.setVisible(false);
						break;
					}
					resultado2.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				case 3:
					switch (dadoAntigo) {
					case 1:
						resultado1.setVisible(false);
						break;
					case 2:
						resultado2.setVisible(false);
						break;
					case 3:
						break;
					case 4:
						resultado4.setVisible(false);
						break;
					case 5:
						resultado5.setVisible(false);
						break;
					case 6:
						resultado6.setVisible(false);
						break;
					}
					resultado3.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				case 4:
					switch (dadoAntigo) {
					case 1:
						resultado1.setVisible(false);
						break;
					case 2:
						resultado2.setVisible(false);
						break;
					case 3:
						resultado3.setVisible(false);
						break;
					case 4:
						break;
					case 5:
						resultado5.setVisible(false);
						break;
					case 6:
						resultado6.setVisible(false);
						break;
					}
					resultado4.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				case 5:
					switch (dadoAntigo) {
					case 1:
						resultado1.setVisible(false);
						break;
					case 2:
						resultado2.setVisible(false);
						break;
					case 3:
						resultado3.setVisible(false);
						break;
					case 4:
						resultado4.setVisible(false);
						break;
					case 5:
						break;
					case 6:
						resultado6.setVisible(false);
						break;
					}
					resultado5.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				case 6:
					switch (dadoAntigo) {
					case 1:
						resultado1.setVisible(false);
						break;
					case 2:
						resultado2.setVisible(false);
						break;
					case 3:
						resultado3.setVisible(false);
						break;
					case 4:
						resultado4.setVisible(false);
						break;
					case 5:
						resultado5.setVisible(false);
						break;
					case 6:
						break;
					}
					resultado6.setVisible(true);
					dadoAntigo = rolaDado;
					break;
				}

			}

		});
	}

	// configurando botao de voltar
	private void configuraBtVoltar() {
		// btVoltar.setBounds(10, 10, 100, 20);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.voltaTela();

			}

		});
	}

	private void configuraBtMenu() {
		btMenu.setBounds(1220, 30, 100, 105);
		btMenu.setBorderPainted(false);
		btMenu.setFocusable(false);
		btMenu.setContentAreaFilled(false);
		add(btMenu);
		btMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
}