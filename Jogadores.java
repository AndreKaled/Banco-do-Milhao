import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jogadores extends JPanel {
    // instanciação das coisinhas

    private JLabel panelLilás, panelVerde, panelRosa; //panelAmarelo, panelVermelho, panelLaranja;
    private JLabel lbTituloJogadores;
    private JButton panelVoltar, btJogar;
    private int contX = 0, contY = 0;
    private static String nome = "JOGADORES";
    private JPanel modoFacil = new ModoFacil(), modoDificil = new ModoDificil();

    // imagens
    private ImageIcon imgTitulo = new ImageIcon(getClass().getResource("Jogadores.png")),
            imgLilas = new ImageIcon(getClass().getResource("jogador lilás.png")),
            imgJogar = new ImageIcon(getClass().getResource("jogar2.png")),
            imgVoltar = new ImageIcon(getClass().getResource("botao voltar.png")),
            imgVerde = new ImageIcon (getClass().getResource("jogador verde.png"));
    		//imgRosa = new ImageIcon (getClass().getResource("jogador rosa.png"));

    // construtor da classe
    public Jogadores() {
        setLayout(null);
        setBackground(new Color(66, 153, 206));
        lbTituloJogadores = new JLabel(imgTitulo);
        panelLilás = new JLabel(imgLilas);
        panelVerde = new JLabel (imgVerde);
        //panelRosa = new JLabel (imgRosa);
        btJogar = new JButton(imgJogar);

        configuraBtVoltar();
        configurapanel();
        configuraBtJogar();

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

    public void configurapanel() {
        add(panelLilás);
        panelLilás.setLayout(null);
        panelLilás.setBounds(130, 170, 350, 150);

        add (panelVerde);
        panelVerde.setLayout(null);
        panelVerde.setBounds(130, 300, 350, 150);
        add(lbTituloJogadores);
        
        /*add (panelRosa);
        panelRosa.setLayout(null);
        panelRosa.setBounds(130, 430, 350, 150);
        add(lbTituloJogadores);*/
        
        lbTituloJogadores.setLayout(null);
        lbTituloJogadores.setBounds(383, -250, 500, 600);

    }

    public void configuraBtJogar() {
        add(btJogar);
        btJogar.setLayout(null);
        btJogar.setBounds(1200, 620, 150, 60);
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