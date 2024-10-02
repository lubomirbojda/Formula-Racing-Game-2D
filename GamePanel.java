import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.swing.JPanel;

/**
 * Trieda slúžiaca na vykresľovanie všetkého na panel.
 * 
 * @author Ľubomír Bojda
 */
public class GamePanel extends JPanel implements Runnable {
    /**
     * Pôvodná velkosť jednej kocky pozadia.
     */
    public static final int ORIGINAL_TILE_SIZE = 16;
    /**
     * Koľkonásobné zväčšenie.
     */
    public static final int SCALE = 3;
    /**
     * Finálna veľkosť jednej kocky panelu.
     */
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    /**
     * Počet kociek v riadku.
     */
    public static final int MAX_SCREEN_COL = 16;
    /**
     * Počet kociek v stĺpci.
     */
    public static final int MAX_SCREEN_ROW = 18;
    /**
     * Počet pixelov šírky obrazovky.
     */
    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    /**
     * Počet pixelov výšky obrazovky.
     */
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
    
    private int fps = 60;

    private Ovladanie ovladanie;
    private UkladacKociek ukladacKociek;
    private Hrac hrac;
    private DetekciaNarazu detekciaNarazu;
    private VyrobaPrekazok vyrobaPrekazok;
    private HlavneMenu hlavneMenu;

    private boolean obnovenieNekonecnehoLevelu;
    
    private Thread gameThread;
    
    /**
     * Konštruktor inicializuje všetky atribúty, priradí hodnoty. 
     */
    public GamePanel() {
        this.ovladanie = new Ovladanie();
        this.ukladacKociek = new UkladacKociek(this);
        this.hrac = new Hrac(this);
        this.detekciaNarazu = new DetekciaNarazu(this);
        this.vyrobaPrekazok = new VyrobaPrekazok(this);
        this.hlavneMenu = new HlavneMenu();
        this.add(this.hlavneMenu.getTlacitko1());
        this.add(this.hlavneMenu.getTlacitko2());
        this.add(this.hlavneMenu.getTlacitko3());
        this.add(this.hlavneMenu.getTlacitkoObtiaznostLahka());
        this.add(this.hlavneMenu.getTlacitkoObtiaznostStredna());
        this.add(this.hlavneMenu.getTlacitkoObtiaznostTazka());
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(this.ovladanie);
        this.setFocusable(true);

        this.obnovenieNekonecnehoLevelu = false;
    }
    
    /**
     * Vráti atribút ovladanie.
     * 
     * @return ovládanie
     */
    public Ovladanie getOvladanie() {
        return this.ovladanie;
    }

    /**
     * Vráti atribút hrac.
     * 
     * @return hrac
     */
    public Hrac getHrac() {
        return this.hrac;
    }

    /**
     * Vráti atribút ukladacKociek.
     * 
     * @return ukladacKociek
     */
    public UkladacKociek getUkladacKociek() {
        return this.ukladacKociek;
    }

    /**
     * Vráti atribút detekciaNarazu.
     * 
     * @return detekciaNarazu
     */
    public DetekciaNarazu getDetekciaNarazu() {
        return this.detekciaNarazu;
    }

    /**
     * Vráti atribút vyrobaPrekazok.
     * 
     * @return vyrobaPrekazok
     */
    public VyrobaPrekazok getVyrobaPrekazok() {
        return this.vyrobaPrekazok;
    }

    /**
     * Vráti atribút hlavneMenu.
     * 
     * @return hlavneMenu
     */
    public HlavneMenu getHlavneMenu() {
        return this.hlavneMenu;
    }
    
    /**
     * Metóda, ktorá spustí hru.
     * 
     * @author RyiSnow (https://www.youtube.com/watch?v=VpH33Uw-_0E)
     */
    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    } 

    /**
     * Nastaví atribút obnovenia nekonečného levelu (true/false).
     * 
     * @ param x nekonečný level sa spustí od začiatku alebo nie
     */
    public void setObnovenieNekonenehoLevelu(boolean x) {
        this.obnovenieNekonecnehoLevelu = x;
    }

    /**
     * Vráti hodnotu atribútu obnovenieNekonecnehoLevelu.
     * 
     * @return obnovenieNekonecnehoLevelu (true/false)
     */
    public boolean getObnovenieNekonecnehoLevelu() {
        return this.obnovenieNekonecnehoLevelu;
    }


    /**
     * Metóda, ktorá na základe atribútu fps rozhodne, koľkokrát za sekundu 
     * obnoví obraz.
     * 
     * @author RyiSnow (https://www.youtube.com/watch?v=VpH33Uw-_0E)
     */
    @Override
    public void run() {

        double drawInterval = 1000000000 / this.fps;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while (this.gameThread != null) {

            if (this.hlavneMenu.getTypLevelu() != Level.MENU) {
                repaint();
            }

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep ((long)remainingTime) ;

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                
            }
        }
    }

    /**
     * Metóda obsahujúca podmienky, na základe ktorých rozhodne, či vykreslí menu, level, alebo
     * obrazovky nárazu, poprípade výhry.
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        
        if (this.detekciaNarazu.getKoniecHry()) {
            this.hrac.setZakladnaPozicia();
            this.ukladacKociek.setSubor(null);
            
            this.hlavneMenu.setVyberObtiaznosti(false);
            this.hlavneMenu.setTypLevelu(Level.MENU);
            this.hlavneMenu.setVybranyLevel(Level.MENU);
            this.hlavneMenu.setObtiaznostLevelu(ObtiaznostLevelu.LAHKA);

            this.hlavneMenu.getTlacitko1().setVisible(true);
            this.hlavneMenu.getTlacitko2().setVisible(true);
            this.hlavneMenu.getTlacitko3().setVisible(true);

            this.detekciaNarazu.setKoniecHry(false);

        }
        
        if (this.hlavneMenu.getTypLevelu() != Level.MENU) {

            if (this.hlavneMenu.getTypLevelu() == Level.NARAZ) {

                this.hlavneMenu.obrazovkaNaraz(g2);

                this.hrac.stlacenaKlavesa();
                
            } else if (this.hlavneMenu.getTypLevelu() == Level.NARAZ_NEKONECNY_LEVEL) {

                this.hlavneMenu.obrazovkaNarazNekonecnyLevel(g2);
                this.vyrobaPrekazok.vykresliSkore(g2);

                this.hrac.stlacenaKlavesa();

            } else if (this.hlavneMenu.getTypLevelu() == Level.VYHRA) {
                this.hlavneMenu.obrazovkaVyhra(g2);
                this.vyrobaPrekazok.vitaznyCas(g2);

                this.hrac.stlacenaKlavesa();

            } else {
                
                try {
                    this.ukladacKociek.nacitajLevel(g2);
                    
                } catch (IOException e) {   
                    
                }
                this.vyrobaPrekazok.vykresleniePrekazok(g2);
                    
    
                this.hrac.posun();
                this.hrac.kresli(g2);
                if (this.hlavneMenu.getTypLevelu() == Level.NEKONECNY_LEVEL) {
                    this.vyrobaPrekazok.skoreNekonecnyLevel(g2);
                } else {
                    this.vyrobaPrekazok.casovac(g2);
                }
    
                this.detekciaNarazu.testNarazu();
                this.detekciaNarazu.vycistiPrekazky();
                    
            }    
        } else {
            this.hlavneMenu.vyberLevelu();
            this.hlavneMenu.vykresliMenuObrazky(g2); 
        }

        g2.dispose();
    }   

}
