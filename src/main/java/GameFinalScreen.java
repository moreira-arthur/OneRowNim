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
    private JButton resetButton;
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

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Serif",Font.BOLD, 20));
        resetButton.setBackground(Color.WHITE);
        resetButton.setForeground(Color.BLACK);
        resetButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        finalScreen.add(resetButton, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Serif",Font.BOLD, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.BLACK);
        exitButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        finalScreen.add(exitButton, gbc);
    }
    /**
     * This method performs an action when a button is clicked.
     *
     * @param e The action event.
    */
    public void actionPerformed(ActionEvent e) {
        finalScreen.dispose();
        if(e.getSource() == resetButton){
            new GameStartScreen();
        }
    }
}