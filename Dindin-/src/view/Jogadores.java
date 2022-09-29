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
    // instancia��o das coisinhas
    private JTextField TfLilas, TfRosa, TfVerde;
    private JTextField TfAmarelo, TfVermelho, TfLaranja;
    
    private JLabel panelLilas, panelRosa, panelVerde;
    private JLabel panelAmarelo, panelVermelho, panelLaranja;
    private JLabel lbTituloJogadores;
    
    private JButton panelVoltar, btJogar;
    
    private int contX = 0, contY = 0;
    private static String nome = "JOGADORES";
    private JPanel modoFacil = new ModoFacil(), modoDificil = new ModoDificil();

    // imagens
    private ImageIcon imgTitulo = new ImageIcon(getClass().getResource("Jogadores.png"));
    private ImageIcon imgLilas = new ImageIcon(getClass().getResource("jogador lilás.png"));
    private ImageIcon imgJogar = new ImageIcon(getClass().getResource("jogar2.png"));
    private ImageIcon imgVoltar = new ImageIcon(getClass().getResource("botao voltar.png"));

    // construtor da classe
    public Jogadores() {
        setLayout(null);
        setBackground(new Color(66, 153, 206));
        lbTituloJogadores = new JLabel(imgTitulo);
        panelLilas = new JLabel(imgLilas);
        btJogar = new JButton(imgJogar);

        configuraBtVoltar();
        configurapanel();
        configuraBtJogar();

        setName(nome);

    }

    /** configurando o bot�o de voltar */
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

    public void configurapanel() {
        add (panelLilas);
        panelLilas.setLayout(null);
        panelLilas.setBounds(400, 600, 200, 60);

    }

    public void configuraBtJogar() {
        add(btJogar);
        btJogar.setLayout(null);
        btJogar.setBounds(1200, 640, 150, 60);
        btJogar.setContentAreaFilled(false);
        btJogar.setBorderPainted(false);
        
        btJogar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ModoDeJogo.getOpcao()==modoFacil.getName()){
					if(contY == 0){
						contY++;
						Menu.adicionaTela(modoFacil, modoFacil.getName());
					}
					Menu.mudaTela(modoFacil.getName());
				}else{
					if(contX == 0){
						contX++;
						Menu.adicionaTela(modoDificil, modoDificil.getName());
					}
					Menu.mudaTela(modoDificil.getName());
				}
			}
        	
        });
    }

    //metodos de acesso
    public void setNome(String nome){
    	this.nome = nome;
    }
    
    public String getNome(){
    	return nome;
    }
}
