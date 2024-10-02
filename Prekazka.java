import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.IOException;
import java.awt.Graphics2D;

/**
 * Trieda vytvorí jednu prekážku na mape na základe zadaných parametrov v konštruktore.
 * 
 * @author Ľubomír Bojda
 */
public class Prekazka {
    private GamePanel gp;

    private BufferedImage obr1;
    private BufferedImage obr2;
    private BufferedImage obr3;
    private BufferedImage obr4;
    private BufferedImage obr5;
    private BufferedImage obr6;
    private BufferedImage obr7;
    private BufferedImage obr8;
    private BufferedImage obr9;
    private BufferedImage obr10;
    private BufferedImage obr11;
    private BufferedImage obr12;
    
    private int zaciatokX;
    private int aktualneX;
    private int aktualneY;
    private int koniecX;
    private boolean jeNaKonci;
    private boolean jeNaZaciatku;
    private boolean ideDoprava;
    private boolean pohybliva;
    private int cisloPrekazky;

    private int rychlost;

    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty, načíta obrázky prekážok.
     * 
     * @param gp Herný panel na vykresľovanie
     * @param cisloPrekazky na zíklade čísla sa rozhodne, ako bude prekážka vyzerať
     * @param zaciatokX určuje začiatočnú x-ovú pozíciu prekážky
     * @param zaciatokY určuje začiatočnú y-ovú pozíciu prekážky
     * @param koniecX určuje koncovú x-ovú pozíciu prekážky
     * @param ideDoprava určuje, či ide prekážka zľava doprava alebo zprava doľava
     * @param pohybliva určuje, či je prekážka pohyblivá alebo statická
     */
    public Prekazka(GamePanel gp, int cisloPrekazky, int zaciatokX, int zaciatokY, int koniecX, boolean ideDoprava, boolean pohybliva) {

        this.nacitajPrekazky();

        this.gp = gp;

        this.cisloPrekazky = cisloPrekazky;

        this.zaciatokX = zaciatokX;
        this.aktualneX = zaciatokX;
        this.aktualneY = zaciatokY;
        this.koniecX = koniecX;
        this.ideDoprava = ideDoprava;
        this.pohybliva = pohybliva;

        this.jeNaKonci = false;
        this.jeNaZaciatku = true;

        this.rychlost = 1;

    }

    /**
     * Načíta obrázky prekážok.
     */
    public void nacitajPrekazky() {

        try {

            this.obr1 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka1.png"));
            this.obr2 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka2.png"));
            this.obr3 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka3.png"));
            this.obr4 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka4.png"));
            this.obr5 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka5.png"));
            this.obr6 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka6.png"));
            this.obr7 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka7.png"));
            this.obr8 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka8.png"));
            this.obr9 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka9.png"));
            this.obr10 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka10.png"));
            this.obr11 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka11.png"));
            this.obr12 = ImageIO.read(getClass().getResourceAsStream("prekazky/prekazka12.png"));

        } catch (IOException e) {
            
        }
    }

    /**
     * Nastaví rýchlosť pohybu prekážky.
     * 
     * @param x rýchlosť prekážky
     */
    public void setRychlost(int x) {
        this.rychlost = x;
    }

    /**
     * Vráti hodnotu rýchlosti prekážky.
     * 
     * @return rýchlosť prekážky
     */
    public int getRychlost() {
        return this.rychlost;
    }

    /**
     * Metóda rozhoduje na základe obtiažnosti levelu, aká bude rýchlosť prekážky.
     */
    public void rozhodniAkaBudeRychlost() {
        if (this.gp.getHlavneMenu().getObtiaznostLevelu() == ObtiaznostLevelu.LAHKA) {
            this.rychlost = 2;
        }

        if (this.gp.getHlavneMenu().getObtiaznostLevelu() == ObtiaznostLevelu.STREDNA) {
            this.rychlost = 4;
        }

        if (this.gp.getHlavneMenu().getObtiaznostLevelu() == ObtiaznostLevelu.TAZKA) {
            this.rychlost = 6;
        }

    }
    
    /**
     * Zistí, kde sa aktuálne nachádza prekážka a vykreslí ju.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void vykresliPrekazku(Graphics2D g2) {

        if (this.gp.getObnovenieNekonecnehoLevelu()) {
            this.rychlost = 1;
            this.gp.setObnovenieNekonenehoLevelu(false);
        }

        this.rozhodniAkaBudeRychlost();
        
        if (this.pohybliva) {
            
            if (this.ideDoprava) {

                if (this.aktualneX <= this.zaciatokX) {
        
                    this.jeNaZaciatku = true;
                    this.jeNaKonci = false;
                }
        
                if (this.aktualneX >= this.koniecX) {
        
                    this.jeNaKonci = true;
                    this.jeNaZaciatku = false;
                }
        
                if (this.jeNaZaciatku) {
                    this.aktualneX += this.rychlost;
                }
        
                if (this.jeNaKonci) {
                    this.aktualneX -= this.rychlost;
                }
            }
    
    
            if (!this.ideDoprava) {
                    
                if (this.aktualneX >= this.zaciatokX) {
        
                    this.jeNaZaciatku = true;
                    this.jeNaKonci = false;
                }
        
                if (this.aktualneX <= this.koniecX) {
        
                    this.jeNaKonci = true;
                    this.jeNaZaciatku = false;
                }
        
                if (this.jeNaZaciatku) {
                    this.aktualneX -= this.rychlost;
                }
        
                if (this.jeNaKonci) {
                    this.aktualneX += this.rychlost;
                }
            }
        }



        BufferedImage prekazka = null;

        if (this.cisloPrekazky == 1) {
            prekazka = this.obr1;
        } else if (this.cisloPrekazky == 2) {
            prekazka = this.obr2;
        } else if (this.cisloPrekazky == 3) {
            prekazka = this.obr3;
        } else if (this.cisloPrekazky == 4) {
            prekazka = this.obr4;
        } else if (this.cisloPrekazky == 5) {
            prekazka = this.obr5;
        } else if (this.cisloPrekazky == 6) {
            prekazka = this.obr6;
        } else if (this.cisloPrekazky == 7) {
            prekazka = this.obr7;
        } else if (this.cisloPrekazky == 8) {
            prekazka = this.obr8;
        } else if (this.cisloPrekazky == 9) {
            prekazka = this.obr9;
        } else if (this.cisloPrekazky == 10) {
            prekazka = this.obr10;
        } else if (this.cisloPrekazky == 11) {
            prekazka = this.obr11;
        } else if (this.cisloPrekazky == 12) {
            prekazka = this.obr12;
        } 
            
        g2.drawImage(prekazka, this.aktualneX, this.aktualneY, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null); 
        
        this.gp.getDetekciaNarazu().setPrekX(this.aktualneX);
        this.gp.getDetekciaNarazu().setPrekY(this.aktualneY);
        this.gp.getDetekciaNarazu().hitboxPrekazok();


        
    }
}
