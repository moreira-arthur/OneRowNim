import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the final screen of the game.
 * It extends JFrame and implements ActionListener.
 * The final screen displays the winner of the game.
 */
public class GameFinalScreen extends JFrame implements ActionListener {
    private final JFrame finalScreen;

    /**
     * Constructor for the GameFinalScreen class.
     * It initializes the final screen with the winner's details.
     *
     * @param winner The player number who won the game.
     */
    public  GameFinalScreen(int winner){
        finalScreen = new JFrame("Final Screen");
        finalScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        finalScreen.setSize(900,900);
        finalScreen.setLayout(new GridBagLayout());
        finalScreen.setLocationRelativeTo(null);
        finalScreen.getContentPane().setBackground(new Color(85, 13, 18));
        finalScreen.setVisible(true);
        
        initAndAddComponents(winner);
    }
    
    /**
     * This method initializes and adds components to the final screen.
     *
     * @param winner The player number who won the game.
     */
    public void initAndAddComponents(int winner){
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,10,10);

        JLabel victoryLabel = new JLabel("Congratulations!! Player " + winner + " is the winner!!");
        victoryLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        victoryLabel.setFont(new Font("Serif",Font.BOLD, 30));
        victoryLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        finalScreen.add(victoryLabel, gbc);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Serif",Font.BOLD, 20));
        resetButton.setBackground(Color.WHITE);
        resetButton.setForeground(Color.BLACK);
        resetButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        finalScreen.add(resetButton, gbc);
    }
    public void actionPerformed(ActionEvent e) {
        finalScreen.dispose();
        new GameStartScreen();
    }
    public static void main(String[] args) {
        new GameFinalScreen(1);
    }
}