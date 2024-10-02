import java.awt.image.BufferedImage;

/**
 * Trieda jednej kocky na pozadí.
 * 
 * @author Ľubomír Bojda
 */
public class Kocka {
    private BufferedImage image;
    
    /**
     * Konštruktor.
     */
    public Kocka() { 
    }

    /**
     * Nastaví obrázok kocky.
     * 
     * @param x obrázok kocky
     */
    public void setKocka(BufferedImage x) {
        this.image = x;
    }

    /**
     * Vráti obrázok kocky.
     * 
     * @return obrázok kocky
     */
    public BufferedImage getKocka() {
        return this.image;
    }
}


