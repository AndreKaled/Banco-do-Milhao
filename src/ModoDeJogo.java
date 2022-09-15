import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ModoDeJogo extends JPanel{

	private JPanel panelFacil,panelDificil;
	private JButton btVoltar;
	private JPanel telaFacil = new ModoFacil(),telaDificil = new ModoDificil();
	private int contX = 0,contY = 0;

	public ModoDeJogo(){
		setLayout(null);
		panelFacil = new JPanel();
		panelDificil = new JPanel();
		btVoltar = new JButton("VOLTAR");
		
		configuraPanels();
		configuraBtVoltar();
		eventos();
		
		//nome do painel para o cardLayout
		setName("MODO DE JOGO");
	}
	
	private void configuraPanels(){
		panelFacil.setBounds(205,150,400,300);
		panelDificil.setBounds(625,150,400,300);
		panelFacil.setBackground(Color.BLACK);
		panelDificil.setBackground(Color.BLACK);
		
		add(panelFacil);
		add(panelDificil);
	}
	
	/**BUG AQUI
	 * ARRUMAR A VOLTA DA TELA AO MODO DE JOGO*/
	private void configuraBtVoltar(){
		btVoltar.setBounds(10,10,100,20);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.voltaTela();
			}
			
		});
	}
	/**BUG AQUI
	 * ARRUMAR A VOLTA DA TELA AO MODO DE JOGO*/
	private void eventos(){
		panelFacil.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//adicionando ao cardLayout
				if(telaFacil == null||contY == 0){
					telaFacil = new ModoFacil();
					Menu.adicionaTela(telaFacil, telaFacil.getName());
					contY++;
				}
				//mudando tela
				Menu.mudaTela(telaFacil.getName());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		panelDificil.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				//adicionando ao cardLayout
				if(telaDificil == null||contX ==0){
					telaDificil = new ModoDificil();
					Menu.adicionaTela(telaDificil, telaDificil.getName());
					contX++;
				}
				//mudando tela
				Menu.mudaTela(telaDificil.getName());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
