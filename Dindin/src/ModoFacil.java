package view;

/**André Kaled Duarte - 28/09/2022
 * 
 * Modo fácil
 * essa classe deve ser um dos modos de jogo escolhido pelo usuário, as configurções do jogo são
 * definidas para iniciantes porém a interface continua a mesma, aqui é onde será a area principal do jogo pois
 * é onde os jogadores passarão mais tempo.
 * 
 * Dado? ok
 * Vez do jogador a mostra? ok
 * Tabuleiro? X
 * Conectado posição do personagem? X
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
	ImageIcon imgFundo = new ImageIcon(getClass().getResource("area-jogador-da-vez.png")),
			imgLista = new ImageIcon(getClass().getResource("botão lista.png")),
			imgMoeda = new ImageIcon(getClass().getResource("moeda-java.png")),
			imgPersonagem = new ImageIcon(getClass().getResource("personagem.png")),
			imgNome = new ImageIcon(getClass().getResource("nome.png")),
			imgMenu = new ImageIcon(getClass().getResource("botao-menu.png"));
	//Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(getClass().getResource("VCR_OSD_MONO_1.001.ttf")));

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
