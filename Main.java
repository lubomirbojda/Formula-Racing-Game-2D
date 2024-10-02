import javax.swing.JFrame;
/**
 * Trieda Main, pomocou ktorej sa spúšťa celý program.
 * 
 * @author Ľubomír Bojda
 */
public class Main {
    /**
     * Metóda main obsahuje príkazy, ktoré sa vykonajú po spustení programu.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame();
        
        window.setTitle("Formule");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
