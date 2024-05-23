import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the start screen of the game.
 * It extends JFrame and implements ActionListener.
 * The start screen asks the user how many computers are playing.
 */
public class GameStartScreen extends JFrame implements ActionListener {
    private JFrame startScreen;
    private GridBagConstraints gbc;
    private JLabel amount;
    private JTextField inputPlayer;
    private JButton startButton;

    /**
     * Constructor for the GameStartScreen class.
     * It initializes the start screen and makes it visible.
     */
    public GameStartScreen(){
        startScreen = new JFrame("Start Screen");
        startScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        startScreen.setSize(900,900);
        startScreen.setLayout(new GridBagLayout());
        startScreen.setLocationRelativeTo(null);
        startScreen.getContentPane().setBackground(new Color(32, 187, 251));

        startScreen.setVisible(true);
        initAndAddComponents();
    }

    /**
     * This method initializes and adds components to the start screen.
     */
    public void initAndAddComponents(){
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,10,10);

        amount = new JLabel("How many computers are playing, 0, 1, or 2? ");
        amount.setFont(new Font("Serif",Font.BOLD, 20));
        // ...
    }
    // ...
}