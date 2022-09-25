package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**André Kaled Duarte e Kauan Ferreira dos Santos - 07/09/2022
 * 
 * COMFIRMAÇÃO DA SAÍDA DO JOGO
 * Essa clase tem o objetivo de confirmar a saída do jogador do jogo Se
 * confirmado, o jogo deve fechar, caso negado o jogo deve continuar na tela
 * antes de precionar o botão de sair
 * */
public class ConfirmaSair extends JFrame {

	// declaracao de variaveis da classe
	private JPanel c;
	private JLabel icone, textoAviso, textoConfirma;
	private JButton btSim, btNao;
	private ImageIcon imagemSair = new ImageIcon(getClass().getResource("Sair.png"));
	final Color corVermelho = new Color(255, 0, 77);
	final Color corVerde = new Color(0, 135, 81);

	// construtor da classe
	public ConfirmaSair() {
		super("Confirmar saída");
		setLayout(null);
		setSize(450, 230);
		c = (JPanel) getContentPane();
		c.setBackground(Color.WHITE);

		configuraTextos();
		configuraIcone();
		configuraBotoes();

		setVisible(true);
	}

	// configura os dois textos
	private void configuraTextos() {
		textoAviso = new JLabel("<html>Se sair todo o seu progresso será perdido!<html>");
		textoConfirma = new JLabel("Deseja realmente sair do jogo?");
		textoAviso.setBounds(110, 20, 330, 50);
		textoAviso.setFont(new Font("Arial", 1, 19));

		add(textoAviso);

		textoConfirma.setBounds(110, 70, 350, 30);
		textoConfirma.setFont(new Font("Arial", 1, 19));
		add(textoConfirma);
	}

	// configura o icone (imagem)
	private void configuraIcone() {
		icone = new JLabel(imagemSair);
		icone.setBounds(25, 25, 70, 70);
		add(icone);
	}

	// configura os dois botões
	private void configuraBotoes() {
		btSim = new JButton("SIM");
		btNao = new JButton("NÃO");
		btSim.setBounds(25,120,180,40);
		btSim.setBackground(corVerde);
		btSim.setForeground(Color.WHITE);
		btSim.setFont(new Font("Arial", 1,19));
		btSim.addActionListener(new FechaJogo());
		btSim.setFocusable(false);
		add(btSim);
		
		btNao.setBounds(225,120,180,40);
		btNao.setBackground(corVermelho);
		btNao.setForeground(Color.WHITE);
		btNao.setFont(new Font("Arial", 1,19));
		btNao.setFocusable(false);
		btNao.addActionListener(new VoltaJogo());
		add(btNao);
	}
	
	//tratando eventos dos botões de confirmação
	private class VoltaJogo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
		
	}
	private class FechaJogo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}
}
