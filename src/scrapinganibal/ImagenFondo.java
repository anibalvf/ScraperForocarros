
package scrapinganibal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImagenFondo extends JPanel {
    
    //atributos
    public Image imagen;
    
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("C:\\Users\\aniba\\Documents\\NetBeansProjects\\ScrapingAnibal\\src\\scrapinganibal\\Imagenesxd\\folder\\yo xd2.jpg")).getImage();
        g.drawImage(imagen,0,0,getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
        
    }
    
    
}
