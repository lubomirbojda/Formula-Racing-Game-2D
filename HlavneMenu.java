import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics2D;

/**
 * Trieda vyrába hlavné menu s tlačítkami pre výber levelu a obtiažnosti.
 * 
 * @author Ľubomír Bojda
 */
public class HlavneMenu implements MouseListener {

    private Level typLevelu;
    private Level vybranyLevel;
    private ObtiaznostLevelu obtiaznostLevelu;
    private JButton tlacitko1;
    private JButton tlacitko2;
    private JButton tlacitko3;
    private JButton tlacitkoObtiaznostLahka;
    private JButton tlacitkoObtiaznostStredna;
    private JButton tlacitkoObtiaznostTazka;
    private BufferedImage obrazokVlavo;
    private BufferedImage obrazokVpravo;
    private BufferedImage obrazovkaNaraz;
    private BufferedImage obrazovkaVyhra;
    private BufferedImage obrazovkaNarazNeoknecnyLevel;

    private boolean vyberObtiaznosti;
    
    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty, načíta obrázky pre hlavné menu.
     */
    public HlavneMenu() {

        this.vyberObtiaznosti = false;
        this.typLevelu = Level.MENU;
        this.vybranyLevel = Level.MENU;
        this.obtiaznostLevelu = ObtiaznostLevelu.LAHKA;

        this.tlacitko1 = new JButton(new ImageIcon("menu/level1.png"));
        this.tlacitko2 = new JButton(new ImageIcon("menu/level2.png"));
        this.tlacitko3 = new JButton(new ImageIcon("menu/nekonecnyLevel.png"));
        this.tlacitkoObtiaznostLahka = new JButton(new ImageIcon("menu/obtiaznostLahka.png"));
        this.tlacitkoObtiaznostStredna = new JButton(new ImageIcon("menu/obtiaznostStredna.png"));
        this.tlacitkoObtiaznostTazka = new JButton(new ImageIcon("menu/obtiaznostTazka.png"));


        
        
        try {

            this.obrazokVlavo = ImageIO.read(getClass().getResourceAsStream("menu/formulaVlavo.png"));
            this.obrazokVpravo = ImageIO.read(getClass().getResourceAsStream("menu/formulaVpravo.png"));
            this.obrazovkaNaraz = ImageIO.read(getClass().getResourceAsStream("menu/obrazovkaNaraz.png"));
            this.obrazovkaVyhra = ImageIO.read(getClass().getResourceAsStream("menu/obrazovkaVyhra.png"));
            this.obrazovkaNarazNeoknecnyLevel = ImageIO.read(getClass().getResourceAsStream("menu/obrazovkaNarazNekonecnyLevel.png"));

        } catch (IOException e) {
            
        }

        this.tlacitko1.addMouseListener(this);
        this.tlacitko2.addMouseListener(this);
        this.tlacitko3.addMouseListener(this);
        this.tlacitkoObtiaznostLahka.addMouseListener(this);
        this.tlacitkoObtiaznostStredna.addMouseListener(this);
        this.tlacitkoObtiaznostTazka.addMouseListener(this);

        this.tlacitkoObtiaznostLahka.setVisible(false);
        this.tlacitkoObtiaznostStredna.setVisible(false);
        this.tlacitkoObtiaznostTazka.setVisible(false);
        
    }

    /**
     * Vykresľuje tlačidlá pre výber levelu.
     */
    public void vyberLevelu() {
            
        if (this.vyberObtiaznosti) {
            this.tlacidlaVyberObtiaznosti();
        } else {
            this.tlacitko1.setBounds(209, 200, 350, 100);
            this.tlacitko2.setBounds(209, 350, 350, 100);
            this.tlacitko3.setBounds(209, 500, 350, 100);
        
       
            this.tlacitko1.repaint();
            this.tlacitko2.repaint();
            this.tlacitko3.repaint();
        }   
    }

    /**
     * Vykresľuje dekoračné obrázku v menu.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void vykresliMenuObrazky(Graphics2D g2) {
        BufferedImage formulaLava = null;
        formulaLava = this.obrazokVlavo;   
        g2.drawImage(formulaLava, 0, 107, 180, 650, null);

        BufferedImage formulaPrava = null;
        formulaPrava = this.obrazokVpravo;   
        g2.drawImage(formulaPrava, 588, 107, 180, 650, null);
    }
    
    /**
     * Vráti tlačítko levelu 1.
     * 
     * @return tlačítko pre level 1
     */
    public JButton getTlacitko1() {
        return this.tlacitko1;
    }
    
    /**
     * Vráti tlačítko levelu 2.
     * 
     * @return tlačítko pre level 2
     */
    public JButton getTlacitko2() {
        return this.tlacitko2;
    }

    /**
     * Vráti tlačítko levelu 3.
     * 
     * @return tlačítko pre level 3
     */
    public JButton getTlacitko3() {
        return this.tlacitko3;
    }

    /**
     * Vráti tlačítko obtiažnosti ľahká.
     * 
     * @return tlačítko pre ľahkú obtiažnosť
     */
    public JButton getTlacitkoObtiaznostLahka() {
        return this.tlacitkoObtiaznostLahka;
    }

    /**
     * Vráti tlačítko obtiažnosti stredná.
     * 
     * @return tlačítko pre strednú obtiažnosť
     */
    public JButton getTlacitkoObtiaznostStredna() {
        return this.tlacitkoObtiaznostStredna;
    }

    /**
     * Vráti tlačítko obtiažnosti ťažká.
     * 
     * @return tlačítko pre ťažkú obtiažnosť
     */
    public JButton getTlacitkoObtiaznostTazka() {
        return this.tlacitkoObtiaznostTazka;
    }

    /**
     * Vráti vybranú obtiažnosť levelu z enum triedy.
     * 
     * @return vybraná obtiažnosť
     */
    public ObtiaznostLevelu getObtiaznostLevelu() {
        return this.obtiaznostLevelu;
    }

    /**
     * Nastaví finálne vybraný level z enum triedy Level.
     * 
     * @param x finálne vybraný level
     */
    public void setTypLevelu(Level x) {
        this.typLevelu = x;
    }

    /**
     * Nastaví atribútu vybranyLevel (ten slúži ako dočasný ukladač vybraného levelu) level z enum triedy Level.
     * 
     * @param x dočasne uložený level
     */
    public void setVybranyLevel(Level x) {
        this.vybranyLevel = x;
    }

    /**
     * Nastaví hodnotu true/false podľa toho, či si hráč uz vybral obtiažnosť.
     * 
     * @param x vybral si už hráč obtiažnosť? (true/false)
     */
    public void setVyberObtiaznosti(boolean x) {
        this.vyberObtiaznosti = x;
    }

    /**
     * Nastavi atribútu obtiaznostLevelu obtiažnosť z enum triedy ObtiaznostLevelu.
     * 
     * @param x Obtiažnosť levelu z enumu obtiažností
     */
    public void setObtiaznostLevelu(ObtiaznostLevelu x) {
        this.obtiaznostLevelu = x;
    }

    /**
     * Vráti finálne vybraný level.
     * 
     * @return vybraný level
     */
    public Level getTypLevelu() {
        return this.typLevelu;
    }

    /**
     * Vráti true/false, podľa toho, či si hráč vybral obtiažnosť.
     * 
     * @return vybral si už hráč obtiažnosť? (true/false)
     */
    public boolean getVyberObtiaznosti() {
        return this.vyberObtiaznosti;
    }

    /**
     * Vráti dočasne uložený level.
     * 
     * @return dočasne uložený level
     */
    public Level getVybranyLevel() {
        return this.vybranyLevel;
    }

    /**
     * Vykresľuje tlačidlá pre výber obtiažnosti.
     */
    public void tlacidlaVyberObtiaznosti() {
        this.tlacitkoObtiaznostLahka.setBounds(209, 200, 350, 100);
        this.tlacitkoObtiaznostStredna.setBounds(209, 350, 350, 100);
        this.tlacitkoObtiaznostTazka.setBounds(209, 500, 350, 100);
        
       
        this.tlacitkoObtiaznostLahka.repaint();
        this.tlacitkoObtiaznostStredna.repaint();
        this.tlacitkoObtiaznostTazka.repaint();
    }
    
    /**
     * Vykreslí obrazovku po náraze v klasickom leveli.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void obrazovkaNaraz(Graphics2D g2) {
        BufferedImage naraz = null;
        naraz = this.obrazovkaNaraz;   
        g2.drawImage(naraz, 109, 257, 550, 350, null);
    }

    /**
     * Vykreslí obrazovku po náraze v nekonecnom leveli.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void obrazovkaNarazNekonecnyLevel(Graphics2D g2) {
        BufferedImage naraz = null;
        naraz = this.obrazovkaNarazNeoknecnyLevel;   
        g2.drawImage(naraz, 109, 257, 550, 350, null);
    }

    /**
     * Vykreslí obrazovku po výhre v klasickom leveli.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void obrazovkaVyhra(Graphics2D g2) {
        BufferedImage vyhra = null;
        vyhra = this.obrazovkaVyhra;   
        g2.drawImage(vyhra, 109, 257, 550, 350, null);
    }

    /**
     * Čo sa stane po kliknutí myškou.
     * 
     * @param e akcia myši
     */
    public void mouseClicked(MouseEvent e) {
        
        if (e.getComponent() == this.tlacitko1) {
            this.vyberObtiaznosti = true;
            this.vybranyLevel = Level.LEVEL1;
            
            
            this.tlacitkoObtiaznostLahka.setVisible(true);
            this.tlacitkoObtiaznostStredna.setVisible(true);
            this.tlacitkoObtiaznostTazka.setVisible(true);
        }

        if (e.getComponent() == this.tlacitko2) {
            this.vyberObtiaznosti = true;
            this.vybranyLevel = Level.LEVEL2;
            
             
            this.tlacitkoObtiaznostLahka.setVisible(true);
            this.tlacitkoObtiaznostStredna.setVisible(true);
            this.tlacitkoObtiaznostTazka.setVisible(true);
        }

        if (e.getComponent() == this.tlacitko3) {
            this.vybranyLevel = Level.NEKONECNY_LEVEL;
            this.setTypLevelu(Level.NEKONECNY_LEVEL);
            this.obtiaznostLevelu = ObtiaznostLevelu.NEKONECNY_LEVEL;
        }

        this.tlacitko1.setVisible(false);
        this.tlacitko2.setVisible(false);
        this.tlacitko3.setVisible(false);

        if (e.getComponent() == this.tlacitkoObtiaznostLahka) {
            this.typLevelu = this.vybranyLevel;
            this.obtiaznostLevelu = ObtiaznostLevelu.LAHKA;
        }

        if (e.getComponent() == this.tlacitkoObtiaznostStredna) {
            this.typLevelu = this.vybranyLevel;
            this.obtiaznostLevelu = ObtiaznostLevelu.STREDNA;
        }

        if (e.getComponent() == this.tlacitkoObtiaznostTazka) {
            this.typLevelu = this.vybranyLevel;
            this.obtiaznostLevelu = ObtiaznostLevelu.TAZKA;
        }

        if (this.typLevelu != Level.MENU) {
            this.tlacitkoObtiaznostLahka.setVisible(false);
            this.tlacitkoObtiaznostStredna.setVisible(false);
            this.tlacitkoObtiaznostTazka.setVisible(false);
        }

    }
    
    /**
     * Čo sa stane po stlačení tlačítka myšky.
     * 
     * @param e akcia myši
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Čo sa stane po pustení stlačeného tlačítka myšky.
     * 
     * @param e akcia myši
     */
    public void mouseReleased(MouseEvent e) {  
    }

    /**
     * Čo sa stane, keď kurzor myši prejde na plochu.
     * 
     * @param e akcia myši
     */
    public void mouseEntered(MouseEvent e) {   
    }

    /**
     * Čo sa stane, keď kurzor myši odíde z plochy.
     * 
     * @param e akcia myši
     */
    public void mouseExited(MouseEvent e) {  
    }
}
