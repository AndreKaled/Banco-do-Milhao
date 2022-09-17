/**Andr� Kaled Duarte - 10/09/2022
 * 
 * Modo dificil
 * essa classe deve ser um dos modos de jogo escolhido pelo usu�rio, as configur��es do jogo s�o
 * alteradas por�m a interface continua a mesma, aqui � onde ser� a area principal do jogo pois
 * � onde os jogadores passar�o mais tempo.
 * Dado? ok
 * Tabuleiro? X
 * Conectado posi��o do personagem? X
 * Lista de compras do Jogador? X
 * */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ModoDificil extends JPanel{

	//declara��o dos componentes
	private JPanel areaDado;
	private JButton btRolar,btVoltar;
	private JLabel resultado;
	private static String nome = "MODO DIFICIL";
	
	//construtor da classe
	public ModoDificil(){
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		setName(nome);
		
		//instancia��o
		areaDado = new JPanel();
		btRolar = new JButton("ROLAR DADO");
		btVoltar = new JButton("VOLTAR");
		resultado = new JLabel("" +Dado.rolar());
		
		configuraDado();
		configuraBtVoltar();
	}
	
	//configurando area do Dado
	private void configuraDado(){
		areaDado.setBackground(Color.GRAY);
		areaDado.setLayout(new FlowLayout());
		areaDado.add(resultado);
		areaDado.add(btRolar);
		areaDado.setBounds(100,100,100,60);
		
		resultado.setFont(new Font("Arial", 1, 19));
		resultado.setForeground(Color.ORANGE);
		btRolar.setFont(new Font("Arial", 1, 14));
		
		add(areaDado);
		
		btRolar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("" +Dado.rolar());
			}
			
		});
	}

	//configurando botao de voltar
		private void configuraBtVoltar(){
			btVoltar.setBounds(10,10,100,20);
			add(btVoltar);
			btVoltar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Menu.mudaTela(ModoDeJogo.getNome());
					
				}
				
			});
		}
		
	//metodo de acesso a informa��es da classe
	static String getNome(){
		return nome;
	}
}
