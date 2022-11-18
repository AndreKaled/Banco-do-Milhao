package view;

/**Andre Kaled Duarte - 30/09/2022
 * Sarah Pinheiro Antunes - 29/09/2022
 * Graziela da Costa Ralph - 16/10/2022
 * Sarah Pinheiro Antunes - 17/10/2022
 * Graziela da Costa Ralph - 17/10/2022
 * Graziela da Costa Ralph - 23/10/2022
 * Andr� Kaled Duarte - 11/11/2022
 * Graziela da Costa Ralph - 17/11/2022
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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Util.Jogando;
import modelo.Dado;

public class ModoFacil extends JPanel {

	private JPanel areaDado, painelVez;
	private JButton btRolar, btVoltar, btLista, btMenu, btLoja;
	private JLabel resultado, areaVez, moeda, quantMoeda, personagem, nome, lbDado, lbNicknameVez;
	private int rolaDado = 0, dadoAntigo = 0;
	ImageIcon imgFundo = new ImageIcon("Imagens/area-jogador-da-vez.png"),
			imgLista = new ImageIcon("Imagens/botao lista.png"),
			imgMoeda = new ImageIcon("Imagens/moeda-java.png"), imgPersonagem = new ImageIcon("Imagens/personagem.png"),
			imgNome = new ImageIcon("Imagens/nome.png"), 
			imgMenu = new ImageIcon("Imagens/botao-menu.png"),
			imgVoltar = new ImageIcon("Imagens/botao voltar.png"),
			imgRolar = new ImageIcon("Imagens/botao-rola-dado.png"),
			imgPanel = new ImageIcon ("Imagens/Loja - Eletronicos.png");
	ImageIcon DadoIcon;
	private String imgDado[] = { "1", "2", "3", "4", "5", "6" };
	private int VEZ = 0;
	private JButton btPassar;
	
	// testando movimentacao
	Tabuleiro t;
	JLabel pessoa[] = new JLabel[6];
	Tabuleiro.Move move;
	
	//fontes
	Font upheaval, VCR;

	public ModoFacil() {
		setLayout(null);
		setBackground(new Color(200, 133, 238));
		setName("MODO FACIL");
		lbNicknameVez = new JLabel (new Jogando().getJogador().getNickName());
		areaDado = new JPanel();
		btRolar = new JButton(imgRolar);
		btVoltar = new JButton(imgVoltar);
		resultado = new JLabel(imgDado[1]);
		//JLabel lbLoja = new JLabel (imgPanel);
		btMenu = new JButton(imgMenu);
		btLoja = new JButton ("Abrir Loja");

		DadoIcon = new ImageIcon(imgDado[1] + ".png"); // acessa as imagens
		lbDado = new JLabel(DadoIcon);

		
		configuraFonte();
		configuraDado();
		configuraBtVoltar();
		configuraVez();
		configuraBtMenu();
		configuraBtPassar();
		iniciaTabuleiro();
		
	}
	
	private void configuraFonte() {
		//fonte Upheaval
		try{
			upheaval = Font.createFont(Font.TRUETYPE_FONT, 
					new File ("fonte/Upheaval TT (BRK).tff"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
					new File ("fonte/Upheaval TT (BRK).tff")));
			}catch (IOException | FontFormatException e){
				System.out.println("Ops! Erro na fonte");
	}
		//fonte vcr osd
		try{
			VCR = Font.createFont(Font.TRUETYPE_FONT, 
					new File ("VCR OSD Mono.tff"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
					new File ("VCR OSD Mono.tff")));
			}catch (IOException | FontFormatException e){
				System.out.println("Ops! Erro na fonte");
	}
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

		quantMoeda = new JLabel("" +new Jogando().getJogador().getMoedas());
		int x = moeda.getX();
		int y = moeda.getY();
		int w = moeda.getWidth();
		int h = moeda.getHeight();
		quantMoeda.setBounds(x + 60, y + 20, w, h - 50);
		quantMoeda.setFont(new Font ("VCR OSD MONO", Font.PLAIN, 25));
		
		lbNicknameVez.setFont(new Font ("Upheaval TT (BRK)", Font.PLAIN, 25));
		lbNicknameVez.setBounds(110, 8, 90, 30);

		add(areaVez);
		painelVez.add(btLista);
		painelVez.add(moeda);
		painelVez.add(quantMoeda);
		painelVez.add(personagem);
		//painelVez.add(nome);
		painelVez.add(lbNicknameVez);
		eventoBtLista();
	}

	// configurando area do Dado
	private void configuraDado() {

		// config para o painel
		areaDado.setLayout(null);
		areaDado.setOpaque(false);

		// adicionando os componentes
		areaDado.add(btRolar);
		areaDado.add(lbDado);
		add(areaDado);

		// posicionamento e tamanho
		btRolar.setBounds(30, 200, 150, 150);
		lbDado.setBounds(-100, -70, 400, 500);
		areaDado.setBounds(1000, 350, 200, 400);

		// configuraçao da area do botao rolar dado
		btRolar.setContentAreaFilled(false);
		btRolar.setBorderPainted(false);

		btRolar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// desabilitando botao para n�o iniciar um novo movimento enquanto j� movimenta
				btRolar.setEnabled(false);
				btPassar.setEnabled(true);
				
				Dado dado = new Dado();
				int i = dado.rolar();

				DadoIcon = new ImageIcon("Imagens/Dado-" + imgDado[i - 1] + ".png"); // acessa o nome da imagem
				lbDado.setIcon(DadoIcon);
				repaint();

				move.mover(pessoa[new Jogando().getVez()], i);
				repaint();
				
			}

		});
	}

	// configurando botao de voltar
	private void configuraBtVoltar() {
		btVoltar.setBounds(10, 10, 70, 70);
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.mudaTela("MENU");
				new Jogando().limpar();
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

	private void eventoBtLista() {
		btLista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListaDeCompras l = new ListaDeCompras();
			}

		});
	}

	private void instanciandoJogadores() {
		Jogando j = new Jogando();
		for (int i = 0; i < j.tamanho(); i++)
			pessoa[i] = new JLabel(j.jogando.get(i).getNickName());
	}

	private void iniciaTabuleiro() {
		instanciandoJogadores();
		
		// inicializando tabuleiro
		t = new Tabuleiro();
		t.setBounds(250, 20, 800, 520);
		add(t);
		for(int i=0; i< new Jogando().tamanho(); i++)
			t.inicia(pessoa[i]);

		// iniciando movimentacao para ser chamado ao rolar o dado
		move = t.new Move();
	}
	
	private void configuraBtPassar() {
		btPassar = new JButton("PASSAR VEZ");
		
		btPassar.setBounds(10,350,150,25);
		
		add(btPassar);
		
		btPassar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btRolar.setEnabled(true);
				new Jogando().passarVez();
				btPassar.setEnabled(false);
				lbNicknameVez.setText(new Jogando().getJogador().getNickName());
			}
			
		});
	}

}