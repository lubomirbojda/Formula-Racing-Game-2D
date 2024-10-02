import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Trieda slúži na vytváranie rôznych prekážok na základe zadaných parametrov.
 * 
 * @author Ľubomír Bojda
 */
public class VyrobaPrekazok {
    private Prekazka prekazka1;
    private Prekazka prekazka2;
    private Prekazka prekazka3;
    private Prekazka prekazka4;
    private Prekazka prekazka5;
    private Prekazka prekazka6;
    private Prekazka prekazka7;
    private Prekazka prekazka8;
    private Prekazka prekazka9;
    private Prekazka prekazka10;
    private Prekazka prekazka11;
    private Prekazka prekazka12;
    private Prekazka prekazka13;
    private Prekazka prekazka14;
    private Prekazka prekazka15;
    private Prekazka prekazka16;
    private Prekazka prekazka17;
    private Prekazka prekazka18;
    private Prekazka prekazka19;
    private Prekazka prekazka20;
    private Prekazka prekazka21;
    private Prekazka prekazka22;
    private Prekazka prekazka23;
    private Prekazka prekazka24;
    private Prekazka prekazka25;
    private Prekazka prekazka26;
    private Prekazka prekazka27;
    private Prekazka prekazka28;
    private Prekazka prekazka29;
    private Prekazka prekazka30;
    private Prekazka prekazka31;
    private Prekazka prekazka32;
    private Prekazka prekazka33;
    private Prekazka prekazka34;
    private Prekazka prekazka35;
    private Prekazka prekazka36;
    private Prekazka prekazka37;
    private Prekazka prekazka38;
    private Prekazka prekazka39;
    private Prekazka prekazka40;
    private Prekazka prekazka41;
    private Prekazka prekazka42;
    private Prekazka prekazka43;
    private Prekazka prekazka44;
    private Prekazka prekazka45;
    private Prekazka prekazka46;
    private Prekazka prekazka47;
    private Prekazka prekazka48;
    private Prekazka prekazka49;
    private Prekazka prekazka50;
    private Prekazka prekazka51;
    private Prekazka prekazka52;
    private Prekazka prekazka53;
    private Prekazka prekazka54;
    private Prekazka prekazka55;
    private Prekazka prekazka56;
    private Prekazka prekazka57;
    private Prekazka prekazka58;
    private Prekazka prekazka59;
    private Prekazka prekazka60;
    private Prekazka prekazka61;
    private Prekazka prekazka62;
    private GamePanel gp;
    private int casovac;
    private int sekundy;
    private String cas;
    private int skore;
    
    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty.
     * 
     * @param gp Herný panel na vykresľovanie
     */
    public VyrobaPrekazok (GamePanel gp) {
        
        this.gp = gp;
        this.casovac = 0;
        this.sekundy = 0;
        this.cas = Integer.toString(0);

        this.prekazkyPreLevely();
    }

    /**
     * Resetuje skóre pri nekonečnom leveli na nulu.
     */
    public void resetujSkore() {
        this.skore = 0;
    }

    /**
     * Zvysuje skóre o 1 pri nekonečnom leveli.
     */
    public void zvysSkore() {
        this.skore += 1;
    }

    /**
     * Vykresľuje skóre pri hraní nekonečného levelu.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void skoreNekonecnyLevel(Graphics2D g2) {
        String s = Integer.toString(this.skore);
        
        g2.setColor(Color.YELLOW);
        g2.drawString("Skóre:", 15, 20);
        g2.drawString(s, 25, 40);
        g2.dispose();
    }

    /**
     * Vykreslí finálne skóre nekonečného levelu.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void vykresliSkore(Graphics2D g2) {
        String s = Integer.toString(this.skore);

        g2.setColor(Color.YELLOW);
        g2.drawString(s, 384, 410);
        g2.dispose();
    }

    /**
     * Resetuje časovač na nulu pri klasickom leveli.
     */
    public void resetujCasovac() {
        this.casovac = 0;
        this.sekundy = 0;
        this.cas = Integer.toString(0);
    }

    /**
     * Vykreslí víťazný čas po prejdení levelu.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void vitaznyCas(Graphics2D g2) {
        String vitaznyCas = this.cas;

        g2.setColor(Color.YELLOW);
        g2.drawString(vitaznyCas + " sekúnd.", 360, 375);
        g2.dispose();
    }

    /**
     * Vykresľuje aktuálny čas v leveli.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void casovac(Graphics2D g2) {
        this.casovac += 1;

        if (this.casovac == 60) {
            this.sekundy += 1;
            this.casovac = 0;
            this.cas = Integer.toString(this.sekundy);
        }

        g2.setColor(Color.YELLOW);
        g2.drawString("Čas:", 15, 20);
        g2.drawString(this.cas + "s", 25, 40);
        g2.dispose();
    }

    /**
     * Zvýši rýchlosť prekážok o 1 pri nekonečnom leveli.
     */
    public void zvysRychlostNekonecnyLevel() {
        this.prekazka51.setRychlost(this.prekazka51.getRychlost() + 1);
        this.prekazka52.setRychlost(this.prekazka52.getRychlost() + 1);
        this.prekazka53.setRychlost(this.prekazka53.getRychlost() + 1);
        this.prekazka54.setRychlost(this.prekazka54.getRychlost() + 1);
        this.prekazka55.setRychlost(this.prekazka55.getRychlost() + 1);
        this.prekazka56.setRychlost(this.prekazka56.getRychlost() + 1);
        this.prekazka57.setRychlost(this.prekazka57.getRychlost() + 1);
        this.prekazka58.setRychlost(this.prekazka58.getRychlost() + 1);
        this.prekazka59.setRychlost(this.prekazka59.getRychlost() + 1);
        this.prekazka60.setRychlost(this.prekazka60.getRychlost() + 1);
        this.prekazka61.setRychlost(this.prekazka61.getRychlost() + 1);
        this.prekazka62.setRychlost(this.prekazka62.getRychlost() + 1);
    }

    /**
     * Inicializuje prekážky.
     */
    public void prekazkyPreLevely() {
        //1 - a
        this.prekazka1 = new Prekazka(this.gp, 4, 222, 654, 0, false, false);
        this.prekazka2 = new Prekazka(this.gp, 4, 464, 629, 0, false, false);
        this.prekazka3 = new Prekazka(this.gp, 4, 538, 528, 0, false, false);
        this.prekazka4 = new Prekazka(this.gp, 4, 256, 519, 0, false, false);
        this.prekazka5 = new Prekazka(this.gp, 4, 426, 385, 0, false, false);
        this.prekazka6 = new Prekazka(this.gp, 4, 173, 315, 0, false, false);
        this.prekazka7 = new Prekazka(this.gp, 4, 338, 276, 0, false, false);
        this.prekazka8 = new Prekazka(this.gp, 4, 522, 251, 0, false, false);
        this.prekazka9 = new Prekazka(this.gp, 4, 290, 112, 0, false, false);
        this.prekazka10 = new Prekazka(this.gp, 4, 574, 48, 0, false, false);
        this.prekazka11 = new Prekazka(this.gp, 4, 221, 25, 0, false, false);
        //1 - b
        this.prekazka12 = new Prekazka(this.gp, 1, 145, 560, 480, true, true);
        this.prekazka13 = new Prekazka(this.gp, 2, 193, 560, 528, true, true);
        this.prekazka14 = new Prekazka(this.gp, 3, 241, 560, 576, true, true);
        this.prekazka15 = new Prekazka(this.gp, 4, 496, 433, 0, false, false);
        this.prekazka16 = new Prekazka(this.gp, 4, 169, 312, 0, false, false);
        this.prekazka17 = new Prekazka(this.gp, 1, 193, 184, 480, true, true);
        this.prekazka18 = new Prekazka(this.gp, 3, 241, 184, 528, true, true);
        this.prekazka19 = new Prekazka(this.gp, 4, 519, 100, 0, false, false);
        //2 - a
        this.prekazka20 = new Prekazka(this.gp, 5, 144, 611, 336, true, true);
        this.prekazka21 = new Prekazka(this.gp, 7, 576, 611, 384, false, true);
        this.prekazka22 = new Prekazka(this.gp, 8, 248, 506, 0, false, false);
        this.prekazka23 = new Prekazka(this.gp, 8, 472, 519, 0, false, false);
        this.prekazka24 = new Prekazka(this.gp, 8, 356, 418, 0, false, false);
        this.prekazka25 = new Prekazka(this.gp, 8, 144, 255, 336, true, true);
        this.prekazka26 = new Prekazka(this.gp, 8, 384, 255, 576, true, true);
        this.prekazka27 = new Prekazka(this.gp, 8, 272, 81, 0, false, false);
        this.prekazka28 = new Prekazka(this.gp, 8, 500, 56, 0, false, false);
        //2 - b
        this.prekazka29 = new Prekazka(this.gp, 5, 144, 554, 288, true, true);
        this.prekazka30 = new Prekazka(this.gp, 6, 192, 554, 336, true, true);
        this.prekazka31 = new Prekazka(this.gp, 7, 576, 554, 432, false, true);
        this.prekazka32 = new Prekazka(this.gp, 6, 528, 554, 384, false, true);
        this.prekazka33 = new Prekazka(this.gp, 8, 280, 420, 0, false, false);
        this.prekazka34 = new Prekazka(this.gp, 8, 194, 317, 0, false, false);
        this.prekazka35 = new Prekazka(this.gp, 8, 414, 340, 0, false, false);
        this.prekazka36 = new Prekazka(this.gp, 8, 544, 398, 0, false, false);
        this.prekazka37 = new Prekazka(this.gp, 5, 144, 100, 432, true, true);
        this.prekazka38 = new Prekazka(this.gp, 6, 192, 100, 480, true, true);
        this.prekazka39 = new Prekazka(this.gp, 6, 240, 100, 528, true, true);
        this.prekazka40 = new Prekazka(this.gp, 7, 288, 100, 576, true, true);
        //2 - c
        this.prekazka41 = new Prekazka(this.gp, 8, 230, 613, 0, false, false);
        this.prekazka42 = new Prekazka(this.gp, 8, 336, 508, 0, false, false);
        this.prekazka43 = new Prekazka(this.gp, 8, 466, 458, 0, false, false);
        this.prekazka44 = new Prekazka(this.gp, 8, 466, 636, 0, false, false);
        this.prekazka45 = new Prekazka(this.gp, 5, 144, 360, 528, true, true);
        this.prekazka46 = new Prekazka(this.gp, 7, 192, 360, 576, true, true);
        this.prekazka47 = new Prekazka(this.gp, 5, 528, 312, 144, false, true);
        this.prekazka48 = new Prekazka(this.gp, 7, 576, 312, 192, false, true);
        this.prekazka49 = new Prekazka(this.gp, 8, 230, 156, 0, false, false);
        this.prekazka50 = new Prekazka(this.gp, 8, 504, 156, 0, false, false);
        //Nekonecny level
        this.prekazka51 = new Prekazka(this.gp, 12, 357, 644, 0, false, false);
        this.prekazka52 = new Prekazka(this.gp, 12, 233, 564, 0, false, false);
        this.prekazka53 = new Prekazka(this.gp, 12, 509, 564, 0, false, false);
        this.prekazka54 = new Prekazka(this.gp, 12, 372, 348, 0, false, false);
        this.prekazka55 = new Prekazka(this.gp, 12, 144, 424, 576, true, true);
        this.prekazka56 = new Prekazka(this.gp, 12, 576, 270, 144, false, true);      
        this.prekazka57 = new Prekazka(this.gp, 9, 144, 123, 288, true, true);
        this.prekazka58 = new Prekazka(this.gp, 10, 192, 123, 336, true, true);
        this.prekazka59 = new Prekazka(this.gp, 10, 528, 123, 384, false, true);
        this.prekazka60 = new Prekazka(this.gp, 11, 576, 123, 432, false, true);
        this.prekazka61 = new Prekazka(this.gp, 12, 240, 35, 0, false, false);
        this.prekazka62 = new Prekazka(this.gp, 12, 484, 35, 0, false, false);
    }

    /**
     * Metóda vykreľuje prekážky na základe toho, aký level hráč práve hrá.
     * 
     * @param g2 grafika na vykresľovanie 2D tvarov
     */
    public void vykresleniePrekazok(Graphics2D g2) {

        

        if (this.gp.getHlavneMenu().getTypLevelu() == Level.LEVEL1) {
            
            if (this.gp.getUkladacKociek().getPodlevel() == Podlevel.A) {
                //1 - a
                this.prekazka1.vykresliPrekazku(g2);
                this.prekazka2.vykresliPrekazku(g2);
                this.prekazka3.vykresliPrekazku(g2);
                this.prekazka4.vykresliPrekazku(g2);
                this.prekazka5.vykresliPrekazku(g2);
                this.prekazka6.vykresliPrekazku(g2);
                this.prekazka7.vykresliPrekazku(g2);
                this.prekazka8.vykresliPrekazku(g2);
                this.prekazka9.vykresliPrekazku(g2);
                this.prekazka10.vykresliPrekazku(g2);
                this.prekazka11.vykresliPrekazku(g2);
            }

            if (this.gp.getUkladacKociek().getPodlevel() == Podlevel.B) {
                //1 - b
                this.prekazka12.vykresliPrekazku(g2);
                this.prekazka13.vykresliPrekazku(g2);
                this.prekazka14.vykresliPrekazku(g2);
                this.prekazka15.vykresliPrekazku(g2);
                this.prekazka16.vykresliPrekazku(g2);
                this.prekazka17.vykresliPrekazku(g2);
                this.prekazka18.vykresliPrekazku(g2);
                this.prekazka19.vykresliPrekazku(g2);
            }
        } 


        if (this.gp.getHlavneMenu().getTypLevelu() == Level.LEVEL2) {
            
            if (this.gp.getUkladacKociek().getPodlevel() == Podlevel.A) {
                //2 - a
                this.prekazka20.vykresliPrekazku(g2);
                this.prekazka21.vykresliPrekazku(g2);
                this.prekazka22.vykresliPrekazku(g2);
                this.prekazka23.vykresliPrekazku(g2);
                this.prekazka24.vykresliPrekazku(g2);
                this.prekazka25.vykresliPrekazku(g2);
                this.prekazka26.vykresliPrekazku(g2);
                this.prekazka27.vykresliPrekazku(g2);
                this.prekazka28.vykresliPrekazku(g2);
            }

            if (this.gp.getUkladacKociek().getPodlevel() == Podlevel.B) {
                //2 - b   
                this.prekazka29.vykresliPrekazku(g2);
                this.prekazka30.vykresliPrekazku(g2);
                this.prekazka31.vykresliPrekazku(g2);
                this.prekazka32.vykresliPrekazku(g2);
                this.prekazka33.vykresliPrekazku(g2);
                this.prekazka34.vykresliPrekazku(g2);
                this.prekazka35.vykresliPrekazku(g2);
                this.prekazka36.vykresliPrekazku(g2);
                this.prekazka37.vykresliPrekazku(g2);
                this.prekazka38.vykresliPrekazku(g2);
                this.prekazka39.vykresliPrekazku(g2);
                this.prekazka40.vykresliPrekazku(g2);
            }

            if (this.gp.getUkladacKociek().getPodlevel() == Podlevel.C) {
                //2 - c   
                this.prekazka41.vykresliPrekazku(g2);
                this.prekazka42.vykresliPrekazku(g2);
                this.prekazka43.vykresliPrekazku(g2);
                this.prekazka44.vykresliPrekazku(g2);
                this.prekazka45.vykresliPrekazku(g2);
                this.prekazka46.vykresliPrekazku(g2);
                this.prekazka47.vykresliPrekazku(g2);
                this.prekazka48.vykresliPrekazku(g2);
                this.prekazka49.vykresliPrekazku(g2);
                this.prekazka50.vykresliPrekazku(g2);
            }
        }

        if (this.gp.getHlavneMenu().getTypLevelu() == Level.NEKONECNY_LEVEL) {
            //Nekonecny level
                this.prekazka51.vykresliPrekazku(g2);
                this.prekazka52.vykresliPrekazku(g2);
                this.prekazka53.vykresliPrekazku(g2);
                this.prekazka54.vykresliPrekazku(g2);
                this.prekazka55.vykresliPrekazku(g2);
                this.prekazka56.vykresliPrekazku(g2);
                this.prekazka57.vykresliPrekazku(g2);
                this.prekazka58.vykresliPrekazku(g2);
                this.prekazka59.vykresliPrekazku(g2);
                this.prekazka60.vykresliPrekazku(g2);
                this.prekazka61.vykresliPrekazku(g2);
                this.prekazka62.vykresliPrekazku(g2);
            
        }

    }
}
