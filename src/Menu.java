/**
 * André Kaled Duarte - 11/09/2022
 * Tela Principal (MENU) 
 * Essa classe deve representar o a tela Menu do jogo
 * onde o usuário escolhe qual ação realizar antes do
 * jogo de fato começar
 * */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{

	private static JPanel c, cLogo, contPrincipal;
	private JButton btJogar,btConfig,btComoJogar,btSair;
	private JLabel logo,versao;
	protected static CardLayout card = new CardLayout();;
	private JPanel jogar = new ModoDeJogo();
	
	public Menu(){
		super("Din Din");
		//configurando janela
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//inicializando componentes
		btJogar = new JButton("JOGAR");
		btConfig = new JButton("CONFIGURAÇÕES");
		btComoJogar = new JButton("COMO JOGAR");
		btSair = new JButton("SAIR");
		logo = new JLabel("LOGO AQUI");
		versao = new JLabel("Versão beta");
		contPrincipal = (JPanel) getContentPane();
		contPrincipal.setLayout(card);
		cLogo = new JPanel();
		c = new JPanel();
		c.setLayout(null);
		c.setName("MENU");
		
		//configurando componentes
		configuraLogo();
		configuraBtJogar();
		configuraBtConfig();
		configuraBtComoJogar();
		configuraBtSair();
		configuraVersao();
		
		//adicionando componentes
		c.add(cLogo);
		configuraTelas();
		
		//tratando eventos
		trataEventos();
		setVisible(true);
	}
	
	//configura a àrea da logo
	public void configuraLogo(){
		cLogo.setLayout(new FlowLayout());
		cLogo.setBackground(Color.BLACK);
		logo.setForeground(Color.WHITE);
		
		//tamanho da logo
		cLogo.setBounds(455, 132, 400, 200);
		cLogo.add(logo);
	}
	
	//configura o botão de jogar
	public void configuraBtJogar(){
		btJogar.setBounds(505, 340, 300, 50);
		c.add(btJogar);
	}
	
	//configura o botao de configurações
	public void configuraBtConfig(){
		btConfig.setBounds(505,400,140,50);
		c.add(btConfig);
	}
	
	//configura o botao de como Jogar (tutorial)
	public void configuraBtComoJogar(){
		btComoJogar.setBounds(665,400,140,50);
		c.add(btComoJogar);
	}
	
	//configura o botão de sair do jogo
	public void configuraBtSair(){
		btSair.setBounds(1200,640,140,50);
		btSair.setBackground(new Color(100,0,30));
		btSair.setForeground(Color.WHITE);
		c.add(btSair);
	}
	
	//configurando telas com o CardLayout
	protected void configuraTelas(){
		contPrincipal.add(c,c.getName());
		contPrincipal.add(jogar,jogar.getName());
	}
	
	//metodos para manipulação do Container Principal
	static public void mudaTela(String nomeTela){
		card.show(contPrincipal, nomeTela);
	}
	
	static public void adicionaTela(JPanel painel, String nomeTela){
		if(painel != null){
		contPrincipal.add(painel,nomeTela);
		}else{
			System.err.println("ERRO");
		}
	}
	
	static public void voltaTela(){
		card.previous(contPrincipal);
	}
	//area de controle de versão
	public void configuraVersao(){
		versao.setBounds(10,660,100,50);
		c.add(versao);
	}

	public void trataEventos(){
		btSair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConfirmaSair();
			}
		});
		
		btJogar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaTela(jogar.getName());
			}
			
		});
	}
	
	public static void main(String[] args) {
		new Menu();
	}
}