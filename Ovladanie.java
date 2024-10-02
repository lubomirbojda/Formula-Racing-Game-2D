import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Trieda slúži na používanie kláves v hre.
 * 
 * @author Ľubomír Bojda
 */
public class Ovladanie implements KeyListener {

    private boolean horeStlacene;
    private boolean doleStlacene;
    private boolean dolavaStlacene;
    private boolean dopravaStlacene;
    private boolean mStlacene;
    private boolean oStlacene;
    
    /**
     * Konštruktor inicializuje atribúty, priradí im hodnoty.
     */
    public Ovladanie() {
        this.horeStlacene = false;
        this.doleStlacene = false;
        this.dolavaStlacene = false;
        this.dopravaStlacene = false;
        this.mStlacene = false;
        this.oStlacene = false;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené W.
     * 
     * @return Je stlačené W?
     */
    public boolean getHoreStlacene() {
        return this.horeStlacene;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené S.
     * 
     * @return Je stlačené S?
     */
    public boolean getDoleStlacene() {
        return this.doleStlacene;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené A.
     * 
     * @return Je stlačené A?
     */
    public boolean getDolavaStlacene() {
        return this.dolavaStlacene;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené D.
     * 
     * @return Je stlačené D?
     */
    public boolean getDopravaStlacene() {
        return this.dopravaStlacene;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené M.
     * 
     * @return Je stlačené M?
     */
    public boolean getMStlacene() {
        return this.mStlacene;
    }

    /**
     * Vráti true/false, podľa toho, či je stlačené O.
     * 
     * @return Je stlačené O?
     */
    public boolean getOStlacene() {
        return this.oStlacene;
    }

    /**
     * Čo sa stane, keď sa zatlačí tlačítko.
     * 
     * @param e akcia klávesnice
     */
    public void keyPressed(KeyEvent e) {

        int klavesa = e.getKeyCode();

        if (klavesa == KeyEvent.VK_W) {
            this.horeStlacene = true;
        }

        if (klavesa == KeyEvent.VK_S) {
            this.doleStlacene = true;
        }

        if (klavesa == KeyEvent.VK_A) {
            this.dolavaStlacene = true;
        }

        if (klavesa == KeyEvent.VK_D) {
            this.dopravaStlacene = true;  
        }

        if (klavesa == KeyEvent.VK_M) {
            this.mStlacene = true;
        }

        if (klavesa == KeyEvent.VK_O) {
            this.oStlacene = true;
        }


    }

    /**
     * Čo sa stane, keď sa pustí stlačené tlačítko.
     * 
     * @param e akcia klávesnice
     */
    public void keyReleased(KeyEvent e) {
        int klavesa = e.getKeyCode();

        if (klavesa == KeyEvent.VK_W) {
            this.horeStlacene = false;
        }

        if (klavesa == KeyEvent.VK_S) {
            this.doleStlacene = false;
        }

        if (klavesa == KeyEvent.VK_A) {
            this.dolavaStlacene = false;
        }

        if (klavesa == KeyEvent.VK_D) {
            this.dopravaStlacene = false;  
        }

        if (klavesa == KeyEvent.VK_M) {
            this.mStlacene = false;  
        }

        if (klavesa == KeyEvent.VK_O) {
            this.oStlacene = false;  
        }
    }
    
    /**
     * Čo sa stane, keď sa klikne tlačítko.
     * 
     * @param e akcia klávesnice
     */
    public void keyTyped(KeyEvent e) {
    }
}
