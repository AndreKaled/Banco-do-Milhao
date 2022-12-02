package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Creditos extends JFrame{

	JLabel msg;
	
	public Creditos() {
		super("Créditos");
		setLayout(new FlowLayout());
		setSize(250,250);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.CROSSHAIR_CURSOR);
		
		msg = new JLabel("<html>"
				+ "<p> Kauan Ferreira dos Santos </p>"
				+ "<p> Sarah Pinheiro Antunes </p>"
				+ "<p> Graziela da Costa Ralph </p>"
				+ "<p> André Kaled Duarte Coutinho </p>"
				+ "</html>");

		add(msg);
		
		setVisible(true);
	}
}

