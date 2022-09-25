package view;

/**Andr� Kaled Duarte - 10/09/2022
 * 
 * Modo f�cil
 * essa classe deve ser um dos modos de jogo escolhido pelo usu�rio, as configur��es do jogo s�o
 * definidas para iniciantes por�m a interface continua a mesma, aqui � onde ser� a area principal do jogo pois
 * � onde os jogadores passar�o mais tempo.
 * 
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

import modelo.Dado;

public class ModoFacil extends JPanel {

	//declara��o de atributos
	private JPanel areaDado;
	private JButton btRolar, btVoltar;
	private JLabel resultado;

	//construtor da classe
	public ModoFacil() {
		setLayout(null);
		setBackground(new Color(66, 153, 206));
		
		areaDado = new JPanel();
		btRolar = new JButton("ROLAR DADO");
		btVoltar = new JButton("VOLTAR");
		resultado = new JLabel("" + Dado.rolar());

		configuraDado();
		configuraBtVoltar();
		
		//nome para a troca de tela
		setName("MODO FACIL");
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
		btVoltar.setBounds(10, 10, 100, 20);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.mudaTela(ModoDeJogo.getNome());
			}

		});
	}
}
