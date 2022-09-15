import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModoFacil extends JPanel {

	private JPanel areaDado;
	private JButton btRolar, btVoltar;
	private JLabel resultado;

	public ModoFacil() {
		setLayout(null);
		setName("MODO FACIL");
		areaDado = new JPanel();
		btRolar = new JButton("ROLAR DADO");
		btVoltar = new JButton("VOLTAR");
		resultado = new JLabel("" + Dado.rolar());

		configuraDado();
		configuraBtVoltar();
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
		resultado.setForeground(Color.BLUE);
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
				Menu.voltaTela();

			}

		});
	}
}
