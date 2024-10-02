import java.util.ArrayList;

/**
 * Trieda slúži na detekovanie, či hráč narazil do prekážky.
 * 
 * @author Ľubomír Bojda
 */
public class DetekciaNarazu {
    private GamePanel gp;
    private int x;
    private int y;
    private int prekX;
    private int prekY;
    private int pocetX;
    private int pocetY;
    private int pocetPrekXY;
    private int h;

    private boolean koniecHry;

    private ArrayList<Integer> osX;
    private ArrayList<Integer> osY;
    private ArrayList<Integer> prekOsX;
    private ArrayList<Integer> prekOsY;
    private ArrayList<Integer> rohoveBodyX;
    private ArrayList<Integer> rohoveBodyY;
    
    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty.
     * 
     * @param gp Herný panel na vykresľovanie
     */
    public DetekciaNarazu(GamePanel gp) {
        this.gp = gp;
        this.osX = new ArrayList<Integer>();
        this.osY = new ArrayList<Integer>();
        this.prekOsX = new ArrayList<Integer>();
        this.prekOsY = new ArrayList<Integer>();
        this.rohoveBodyX = new ArrayList<Integer>();
        this.rohoveBodyY = new ArrayList<Integer>();
        this.koniecHry = false;
    }

    /**
     * Vráti hodnotu true/false atribútu koniecHry na základe toho, či hráč narazil a chce sa 
     * vrátiť do menu.
     * 
     * @return koniecHry (true/false)
     */
    public boolean getKoniecHry() {
        return this.koniecHry;
    }

    /**
     * Nastaví atribút koniecHry.
     * 
     * @param x je koniec hry? (true/false)
     */
    public void setKoniecHry(boolean x) {
        this.koniecHry = x;
    }

    /**
     * Metóda testuje, či hráč narazil do prekážky.
     */
    public void testNarazu() {
        this.hitboxHraca();

        int p = this.osX.size();

        this.osX.removeAll(this.prekOsX);
        
        int p1 = this.osX.size();

        
        
        int k = this.osY.size();

        this.osY.removeAll(this.prekOsY);
        
        int k1 = this.osY.size();

        
        if (!this.rohoveBodyX.isEmpty()) {
            this.h = 0;
            for (int i = 0; i < this.rohoveBodyX.size(); i++) {
                
                if (this.rohoveBodyX.get(i) - this.gp.getHrac().getX() <= 48 && this.rohoveBodyX.get(i) - this.gp.getHrac().getX() >= -48 && 
                    this.rohoveBodyY.get(i) - this.gp.getHrac().getY() <= 48 && this.rohoveBodyY.get(i) - this.gp.getHrac().getY() >= -48) {
    
                    this.h += 1;
                }
            }
        } 
        
        
        if (p != p1 && k != k1 && this.h > 0) {
           
            if (this.gp.getHlavneMenu().getTypLevelu() == Level.NEKONECNY_LEVEL) {
                this.gp.getHlavneMenu().setTypLevelu(Level.NARAZ_NEKONECNY_LEVEL);
            } else {
                this.gp.getHlavneMenu().setTypLevelu(Level.NARAZ);
            }
            
            this.gp.getHrac().setZakladnaPozicia();       
        } 
         
    }

    /**
     * Nastaví x-ovú súradnicu ľavého horného rohu prekážky.
     * 
     * @param x súradnica X ľavého horného rohu prekážky
     */
    public void setPrekX(int x) {
        this.prekX = x;
    }

    /**
     * Nastaví y-ovú súradnicu ľavého horného rohu prekážky.
     * 
     * @param y súradnica Y ľavého horného rohu prekážky
     */
    public void setPrekY(int y) {
        this.prekY = y;
    }

    /**
     * Odsráni hitboxy (súradnice x a y) prekážok na mape.
     */
    public void vycistiPrekazky() {

        this.prekOsX.clear();
        this.prekOsY.clear();
        this.rohoveBodyX.clear();
        this.rohoveBodyY.clear();
    }
    
    /**
     * Metóda nastaví hitboxy (súradnice x a y) prekážok na mape. 
     */
    public void hitboxPrekazok() {
        this.pocetPrekXY = GamePanel.TILE_SIZE;
        this.rohoveBodyX.add(this.prekX);
        this.rohoveBodyY.add(this.prekY);

        

        
        for (int i = 0; i < this.pocetPrekXY ; i++) {
            this.prekOsX.add(this.prekX + i);
            this.prekOsY.add(this.prekY + i);
        }
    
        this.gp.getUkladacKociek().setJeNacitanaNovaMapa(false);
    }
    
    /**
     * Metóda zistí pozíciu hráča a vyrobí jeho hitboxy (súradnice x a y).
     */
    public void hitboxHraca() {
        this.osX.clear();
        this.osY.clear();
        
        this.x = this.gp.getHrac().getX();
        this.y = this.gp.getHrac().getY();
        this.pocetX = GamePanel.TILE_SIZE;
        this.pocetY = GamePanel.TILE_SIZE;
        
        for (int i = 0; i < this.pocetX ; i++) {
            this.osX.add(this.x + i);
        }

        for (int i = 0; i < this.pocetY ; i++) {
            this.osY.add(this.y + i);
        }
    
        
    
    }    
}
