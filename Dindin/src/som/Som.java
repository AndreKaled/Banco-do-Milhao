package som;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {

	static Clip oClip;
	static AudioInputStream stream;
	static InputStream input;
	static URL oUrl;

	public Som() {
		try {
			oUrl = getClass().getClassLoader().getResource("som/musiquinha.wav");
			oClip = AudioSystem.getClip();
			AudioInputStream oStream;
			oStream = AudioSystem.getAudioInputStream(oUrl);
			oClip.open(oStream);
		} catch (Exception e) {
			System.err.println("Erro ao iniciar som!");
			e.printStackTrace();
		}
	}

	public void tocar() {
		oClip.loop(0);
	}

	public static void loop() {
		oClip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void parar() {
		oClip.stop();
	}
}
