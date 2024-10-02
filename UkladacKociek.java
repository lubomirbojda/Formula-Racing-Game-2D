import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.util.Scanner;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Trida slúži na vykreslenie pozadia mapy, po ktorej sa hráč pohybuje.
 * 
 * @author Ľubomír Bojda
 */
public class UkladacKociek {
   
    private GamePanel gp;
    private Kocka[] kocka;
    
    private ArrayList<Integer> cislaKociek;
    private String subor;

    private boolean jeNacitanaNovaMapa;
    private Podlevel podlevel;

    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty.
     * 
     * @param gp Herný panel na vykresľovanie
     */
    public UkladacKociek (GamePanel gp) {
        this.gp = gp;

        this.podlevel = null;

        this.kocka = new Kocka[10];

        this.subor = null;
        
        this.cislaKociek = new ArrayList<Integer>();

        this.nacitajObrazkyKociek();

        this.jeNacitanaNovaMapa = true;
    }

    /**
     * Načítajú sa png obrázky kociek, ktoré sa následne budú vykreslovať do pozadia.
     */
    public void nacitajObrazkyKociek() {

        try {

            this.kocka[0] = new Kocka();
            this.kocka[0].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/cervenyStvorec.png")));

            this.kocka[1] = new Kocka();
            this.kocka[1].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/bielyStvorecVlavo.png")));

            this.kocka[2] = new Kocka();
            this.kocka[2].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/sivyStvorec.png")));

            this.kocka[3] = new Kocka();
            this.kocka[3].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/ciernyStvorec.png")));

            this.kocka[4] = new Kocka();
            this.kocka[4].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/bielyStvorecVpravo.png")));

            this.kocka[5] = new Kocka();
            this.kocka[5].setKocka(ImageIO.read(getClass().getResourceAsStream("pozadie/bielyStvorec.png")));

        } catch (IOException e) {
            
        }
    }

    /**
     * Nastaví sa cesta k súboru pomocou ktorého sa načítajú obrázky kociek.
     * 
     * @param x Cesta k súboru
     */
    public void setSubor(String x) {
        this.subor = x;
    }

    /**
     * Vráti atribút podlevel.
     * 
     * @return podlevel z enum triedy
     */
    public Podlevel getPodlevel() {
        return this.podlevel;
    }

    /**
     * Metóda zisťuje, ktorá časť levelu je momentálne načítaná a ak hráč prejde na ďalšiu, tak sa
     * zmení.
     */
    public void vyberLevelu() {

        String level1A = "levely/level1/level1a.txt";
        String level1B = "levely/level1/level1b.txt";
        String level2A = "levely/level2/level2a.txt";
        String level2B = "levely/level2/level2b.txt";
        String level2C = "levely/level2/level2c.txt";
        String levelNekonecny = "levely/levelNekonecny/levelNekonecny.txt";

        if (this.gp.getHlavneMenu().getTypLevelu() == Level.LEVEL1) {
            
            if (this.subor == level1A) {
                
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
                    this.subor = level1B;
                    this.podlevel = Podlevel.B;
    
                    this.gp.getHrac().setY(816);
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getDetekciaNarazu().vycistiPrekazky();
                }
            } else if (this.subor == level1B) {
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
                    this.gp.getHlavneMenu().setTypLevelu(Level.VYHRA);

                    this.gp.getHrac().setY(816);
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getDetekciaNarazu().vycistiPrekazky();
                }
            } else {   
                this.subor = level1A;
                this.podlevel = Podlevel.A;
            }
        }

        if (this.gp.getHlavneMenu().getTypLevelu() == Level.LEVEL2) {
           
            if (this.subor == level2A) {
                
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
                    this.subor = level2B;
                    this.podlevel = Podlevel.B;
    
                    this.gp.getHrac().setY(816);
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getDetekciaNarazu().vycistiPrekazky();
                }
            } else if (this.subor == level2B) {
                
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
                    this.subor = level2C;
                    this.podlevel = Podlevel.C;
    
                    this.gp.getHrac().setY(816);
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getDetekciaNarazu().vycistiPrekazky();
                }
                
            } else  if (this.subor == level2C) {
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
                    this.gp.getHlavneMenu().setTypLevelu(Level.VYHRA);
                    this.gp.getHrac().setY(816);
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getDetekciaNarazu().vycistiPrekazky();
                }
            } else {
                this.subor = level2A;
                this.podlevel = Podlevel.A;
            }
        }

        if (this.gp.getHlavneMenu().getTypLevelu() == Level.NEKONECNY_LEVEL) {
           
            if (this.subor == levelNekonecny) {
                
                if (this.gp.getHrac().getY() + GamePanel.TILE_SIZE < 0) {
    
                    this.gp.getHrac().setY(816);
                    this.gp.getVyrobaPrekazok().zvysSkore();
                    this.jeNacitanaNovaMapa = true;
                    this.gp.getVyrobaPrekazok().zvysRychlostNekonecnyLevel();
                    this.gp.getDetekciaNarazu().vycistiPrekazky();

                    
                }

            } else {

                this.subor = levelNekonecny;
                

            }
        }
    }

    /**
     * Nastaví načítaný súbor na null, aby sa mohol výber začať od začiatku.
     */
    public void setSuborNaNull() {
        this.subor = null;
    }

    /**
     * Vráti hodnotu true/false na základe toho, či hráč prešiel jednu mapu a teda sa načítala druhá.
     * 
     * @return jeNacitanaNovaMapa (true/false)
     */
    public boolean getJeNacitanaNovaMapa() {
        return this.jeNacitanaNovaMapa;
    }

    /**
     * Nastaví hodnotu atribútu jeNacitanaNovaMapa (true/false).
     * 
     * @param x boolean (true/false)
     */
    public void setJeNacitanaNovaMapa(boolean x) {
        this.jeNacitanaNovaMapa = x;
    }
    
    /**
     * Vykresľuje pozadie na základe toho, v ktorej časti levelu sa hráč nachádza.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void nacitajLevel(Graphics2D g2) throws IOException {
        
        if (this.gp.getHlavneMenu().getTypLevelu() != Level.MENU) {

            this.vyberLevelu();
        
            File level = new File (this.subor);

            Scanner sken = new Scanner(level);
        
            int riadky = 1;
   
        
            while (sken.hasNextLine()) {
            
            
                for (int c = 1; c < 17; c++) {
                    int y = sken.nextInt();
                    this.cislaKociek.add(y);  
                    
                    
                    
                    
                    g2.drawImage(this.kocka[y].getKocka(), (this.cislaKociek.size() - 1) * 48, (riadky - 1) * 48, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
                    
                  
                    
                }
            
            
                this.cislaKociek.clear();
                riadky++;
            
            }
       
            sken.close();
        
        }

    }
        

}
