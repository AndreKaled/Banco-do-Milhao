package som;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Efeito {

	Player efeitoClick, efeitoCompra;
	InputStream input;
	static boolean efeito = true;

	public Efeito() {
		comEfeito();
	}

	// tocar sons especificos
	public void clicar() {
		if (efeito)
			try {
				input = this.getClass().getResourceAsStream("BEEP.mp3");
				efeitoClick = new Player(input);
				efeitoClick.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				System.err.println("Som inicializado, impossivel executar o play!");
				e.printStackTrace();
			}
	}

	public void comprar() {
		if (efeito)
			try {
				efeitoCompra.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				System.err.println("Som inicializado, impossivel executar o play!");
			}
	}

	// configurando efeitos
	public void comEfeito() {
		efeito = true;
	}

	public void semEfeito() {
		efeito = false;
	}

}
