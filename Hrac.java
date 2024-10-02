import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Trieda Hrac mení hráčovu pozíciu na základe stlačeného tlačítka.
 * 
 * @author Ľubomír Bojda
 */
public class Hrac {
    
    private GamePanel gp;
    
    private int x;
    private int y;
    private int rychlost;

    private BufferedImage up;
    private BufferedImage down;
    private BufferedImage left;
    private BufferedImage right;
    private String direction;

    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty.
     * 
     * @param gp Herný panel na vykresľovanie
     * 
     */
    public Hrac(GamePanel gp) {
        this.gp = gp;
        

        this.setZakladnaPozicia();

        this.nacitajObrazkyHraca();
    }

    /**
     * Vráti x-ovú pozíciu hráča.
     * 
     * @return x-ová pozícia hráča
     */
    public int getX() {
        return this.x;
    }

    /**
     * Vráti y-ovú pozíciu hráča.
     * 
     * @return y-ová pozícia hráča
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vráti rýchlosť hráča.
     * 
     * @return rýchlosť hráča
     */
    public int getRychlost() {
        return this.rychlost;
    }

    /**
     * Nastaví hráčovu x-ovú pozíciu.
     * 
     * @param x nová x-ová pozícia hráča
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Nastaví hráčovu y-ovú pozíciu.
     * 
     * @param x nová y-ová pozícia hráča
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Zistí, či bola stlačená klávesa M alebo O a na základe toho rozhodne, či sa vráti do menu 
     * alebo spustí vybraný level odznova.
     */
    public void stlacenaKlavesa() {
        
        if (this.gp.getOvladanie().getMStlacene()) {
            this.gp.getDetekciaNarazu().setKoniecHry(true);
            this.gp.getVyrobaPrekazok().resetujCasovac();
            this.gp.getVyrobaPrekazok().resetujSkore();
        }

        if (this.gp.getOvladanie().getOStlacene()) {
            this.gp.getUkladacKociek().setSubor(null);
            this.gp.getHlavneMenu().setTypLevelu(this.gp.getHlavneMenu().getVybranyLevel());
            this.gp.setObnovenieNekonenehoLevelu(true);
            this.gp.getVyrobaPrekazok().resetujCasovac();
            this.gp.getVyrobaPrekazok().resetujSkore();
        }
    }

    /**
     * Metóda, ktorá postaví hráča na štartovaciu pozíciu.
     */
    public void setZakladnaPozicia() {
        this.x = 384 - (GamePanel.TILE_SIZE / 2);
        this.y = 816;
        this.rychlost = 4;
        this.direction = "down";
    }

    /**
     * Načíta obrázky hráča.
     */
    public void nacitajObrazkyHraca() {
        try {

            this.up = ImageIO.read(getClass().getResourceAsStream("hrac/formulaHracHoreAleboDole.png"));
            
            this.down = ImageIO.read(getClass().getResourceAsStream("hrac/formulaHracHoreAleboDole.png"));
            
            this.left = ImageIO.read(getClass().getResourceAsStream("hrac/formulaHracVlavo.png"));
            
            this.right = ImageIO.read(getClass().getResourceAsStream("hrac/formulaHracVpravo.png"));
            


        } catch (IOException e) {            
        
        }
    }

    /**
     * Metóda na základe stalčeného tlačítka vykonáva pohyb hráča (mení jeho polohu a obrázok).
     */
    public void posun() {

        if (this.gp.getOvladanie().getHoreStlacene()) {
            this.direction = "up";
            this.y -= this.rychlost;
        }   else if (this.gp.getOvladanie().getDoleStlacene()) {
            
            this.direction = "down";
            
            if (this.y < 816) {
                this.y += this.rychlost;
            } 
        } else if (this.gp.getOvladanie().getDolavaStlacene()) {
            this.direction = "left";
            if (this.x > 144) {
                this.x -= this.rychlost;
            }   
        } else if (this.gp.getOvladanie().getDopravaStlacene()) {
            this.direction = "right";
            if (this.x < 576) { 
                this.x += this.rychlost;
            } 
        } else {
            this.direction = "up";
        }

    }

    /**
     * Metóda vykresľuje obrázok hráča podľa toho, do ktorej strany sa hýbe.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void kresli(Graphics2D g2) {
        BufferedImage image = null;

        switch (this.direction) {
            case "up":
                image = this.up;
                break;
            case "down":
                image = this.down;
                break;
            case "left":
                image = this.left;
                break;
            case "right":
                image = this.right;
                break;
        }
        g2.drawImage(image, this.x, this.y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
        
        
    }   
}
