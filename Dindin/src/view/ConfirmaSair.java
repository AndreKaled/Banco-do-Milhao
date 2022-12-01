package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**Andr� Kaled Duarte e Kauan Ferreira dos Santos - 01/12/2022
 * 
 * COMFIRMACAO DA SAIDA DO JOGO
 * Essa clase tem o objetivo de confirmar a saida do jogador do jogo Se
 * confirmado, o jogo deve fechar, caso negado o jogo deve continuar na tela
 * antes de precionar o botao de sair
 * */

public class ConfirmaSair extends JBackgroundPanel {

	// declaracao de variaveis da classe
	JBackgroundPanel fundoSair;
	JButton btSim,btNao;
	JLabel aviso;
	ImageIcon imgBtSim,imgBtNao;
	
	public ConfirmaSair() throws IOException{
		super("imagens/fundo-confirmar-saida.png");
		setLayout(null);
		setOpaque(false);
		
		imgBtSim = new ImageIcon("Imagens/botao-sim.png");
		imgBtNao = new ImageIcon("Imagens/botao-nao.png");
		
		btSim = new JButton(imgBtSim);
		btNao = new JButton(imgBtNao);
		
		aviso = new JLabel("<html>Se voce sair, perdera o progresso nao salvo, deseja realmente sair do jogo e nos abandonar? :(</html>");
		
		aviso.setBounds(35,150,500,100);
		btSim.setBounds(35,250,240,100);
		btNao.setBounds(btSim.getX()+240+50,250,240,100);
		
		add(aviso);
		add(btSim);
		add(btNao);
		
		btSim.addActionListener(new FechaJogo());
		btNao.addActionListener(new VoltaJogo());
		
		setVisible(false);
	}
	
	public ConfirmaSair(String img) throws IOException{
		super(img);
		setLayout(null);
		setOpaque(false);
		
		imgBtSim = new ImageIcon("Imagens/botao-sim.png");
		imgBtNao = new ImageIcon("Imagens/botao-nao.png");
		
		btSim = new JButton(imgBtSim);
		btNao = new JButton(imgBtNao);
		aviso = new JLabel("<html>Se voce sair, perdera o progresso nao salvo, deseja realmente sair do jogo e nos abandonar? :(<html>");
		
		aviso.setBounds(35,150,500,100);
		btSim.setBounds(35,250,240,100);
		btNao.setBounds(btSim.getX()+240+50,250,240,100);
		
		add(aviso);
		add(btSim);
		add(btNao);
		
		btSim.setBorder(null);
		btSim.setContentAreaFilled(false);
		btSim.setFocusable(false);
		
		btNao.setBorder(null);
		btNao.setContentAreaFilled(false);
		btNao.setFocusable(false);
		
		btSim.addActionListener(new FechaJogo());
		btNao.addActionListener(new VoltaJogo());
		
		setVisible(false);
	}
	
	//tratando eventos dos botoes de confirmacao
	private class VoltaJogo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
		
	}
	private class FechaJogo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}
	
	public void visivel() {
		setVisible(true);
	}
}
