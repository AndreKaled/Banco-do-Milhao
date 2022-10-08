package view;

/**Andr� Kaled Duarte - 30/09/2022
 * Sarah Pinheiro Antunes - 29/09/2022
 * 
 * Modo f�cil
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
	private JButton btRolar, btVoltar, btLista,btMenu;
	private JLabel resultado, areaVez, moeda, quantMoeda, personagem, nome;
	ImageIcon imgFundo = new ImageIcon("Imagens/area-jogador-da-vez.png"),
			imgLista = new ImageIcon("Imagens/imagens/botao lista.png"),
			imgMoeda = new ImageIcon("imagen/moeda-java.png"),
			imgPersonagem = new ImageIcon("imagen/personagem.png"),
			imgNome = new ImageIcon("imagen/nome.png"),
			imgMenu = new ImageIcon("imagen/botao-menu.png");

	public ModoFacil() {
		setLayout(null);
		setBackground(new Color(200, 133, 238));
		setName("MODO FACIL");
		areaDado = new JPanel();
		btRolar = new JButton("ROLAR DADO");
		btVoltar = new JButton("VOLTAR");
		resultado = new JLabel("" + Dado.rolar());
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
		//quantMoeda.setFont(font);

		add(areaVez);
		painelVez.add(btLista);
		painelVez.add(moeda);
		painelVez.add(quantMoeda);
		painelVez.add(personagem);
		painelVez.add(nome);
	}

	// configurando area do Dado
	private void configuraDado() {
		areaDado.setBackground(Color.GRAY);
		areaDado.setLayout(new FlowLayout());
		areaDado.add(resultado);
		areaDado.add(btRolar);
		areaDado.setBounds(100, 100, 100, 100);
		add(areaDado);

		resultado.setFont(new Font("Arial", 1, 19));
		resultado.setForeground(Color.ORANGE);
		btRolar.setFont(new Font("Arial", 1, 14));

		btRolar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("" + Dado.rolar());
			}

		});
	}

	// configurando botao de voltar
	private void configuraBtVoltar() {
		//btVoltar.setBounds(10, 10, 100, 20);
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