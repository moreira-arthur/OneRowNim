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
        amount.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        startScreen.add(amount, gbc);

        inputPlayer = new JTextField();
        inputPlayer.setFont(new Font("Serif",Font.BOLD, 20));
        inputPlayer.setBackground(Color.WHITE);
        inputPlayer.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        startScreen.add(inputPlayer, gbc);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Serif",Font.BOLD, 20));
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        startScreen.add(startButton, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputPlayer.getText();
        try {
            int nComputers = Integer.parseInt(input);
            if (nComputers >= 0 && nComputers < 3) {
                startScreen.dispose();
                new GameScreen(nComputers);

            }else{
                JOptionPane.showMessageDialog(startScreen, "Number of players must be one of the follow numbers: 0, 1, 2.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(startScreen, "Please enter a valid number.");
        }
    }
}