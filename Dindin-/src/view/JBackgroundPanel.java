package view;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/** Classe para permitir imagem de fundo em JPanel*/

public class JBackgroundPanel extends JPanel {
    protected BufferedImage backgroundImage = null;
    
    //construtor default
    public JBackgroundPanel() {
        super();
    }
    
    //construtor com argumento String para adicionar imagem no fundo do JPanel
    public JBackgroundPanel(String img) throws IOException {
        super();
        setBackgroundImage(img);
    }

    public void setBackgroundImage(String resourceLocation) throws IOException {
        URL backgroundUrl = getClass().getClassLoader().getResource(resourceLocation);
        this.backgroundImage = ImageIO.read(backgroundUrl);
    }
 
  //carregando imagem no fundo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}
