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
	boolean efeito = false;
	
	public Efeito(){
		/*try {
			try {
				input = this.getClass().getResourceAsStream("som/BEEP.mp3");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			efeitoClick = new Player(input);	
			efeitoCompra = new Player(input);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Erro ao inicializar efeitos sonoros!\n" +e.getMessage());
		}
		
		comEfeito();*/
	}
	
	//tocar sons especificos
	public void clicar(){
		if(efeito)
			try {
				efeitoClick.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				System.err.println("Som inicializado, impossível executar o play!");
			}
	}
	
	public void comprar(){
		if(efeito)	
			try {
				efeitoCompra.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				System.err.println("Som inicializado, impossível executar o play!");
			}
	}
	
	//configurando efeitos
	public void comEfeito(){
		efeito = true;
	}
	
	public void semEfeito(){
		efeito = false;
	}
	
}
