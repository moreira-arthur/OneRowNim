import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JFrame implements ActionListener{

    private OneRowNim game;
    private int nComputers;
    private JFrame gameScreen;
    private GridBagConstraints gbc;
    private JLabel playerTurn, nStricks;
    private JButton take1, take2, take3;
    private JTextArea outTextArea;


    public GameScreen(int nComputers){
        // GameScreen constructor
        gameScreen = new JFrame("Game Screen");
        gameScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen.setSize(900,900);
        gameScreen.setLayout(new GridBagLayout());
        gameScreen.setLocationRelativeTo(null);
        gameScreen.getContentPane().setBackground(new Color(32, 187, 251));
        gameScreen.setVisible(true);	

        this.nComputers = nComputers;
        game = new OneRowNim();

        initAndAddComponents();
        initGame();
        
    }

    public void initAndAddComponents(){
        // game = new OneRowNim();
        // This method initializes and adds components to the game screen.
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,10,10);

        playerTurn = new JLabel("Player 1's turn");
        playerTurn.setFont(new Font("Serif",Font.BOLD, 20));
        playerTurn.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gameScreen.add(playerTurn, gbc);

        nStricks = new JLabel("Number of sticks left: " + game.getSticks());
        nStricks.setFont(new Font("Serif",Font.BOLD, 20));
        nStricks.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gameScreen.add(nStricks, gbc);

        take1 = new JButton("Take 1");
        take1.setFont(new Font("Serif",Font.BOLD, 20));
        take1.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gameScreen.add(take1, gbc);

        take2 = new JButton("Take 2");
        take2.setFont(new Font("Serif",Font.BOLD, 20));
        take2.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gameScreen.add(take2, gbc);

        take3 = new JButton("Take 3");
        take3.setFont(new Font("Serif",Font.BOLD, 20));
        take3.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gameScreen.add(take3, gbc);


        outTextArea = new JTextArea(10, 30);
        outTextArea.setFont(new Font("Monospaced",Font.PLAIN, 16));
        outTextArea.setBackground(Color.WHITE);
        outTextArea.setForeground(Color.BLACK);
        outTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outTextArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gameScreen.add(scrollPane, gbc);

    }

    public void initGame(){

        JOptionPane.showMessageDialog(gameScreen, game.getRules());
        for (int k = 0; k < nComputers; k++) {
            IPlayer computer = new NimPlayerBad((OneRowNim) game);
            ((TwoPlayerGame) game).addComputerPlayer(computer);
        }
        if (game.computer1 != null)
            outTextArea.append("Player 1 is a " + game.computer1.toString() + "\n");
        if (game.computer2 != null)
            outTextArea.append("Player 2 is a " + game.computer2.toString()+ "\n\n");
        
        if(nComputers == 2){

            take1.setEnabled(false);
            take2.setEnabled(false);
            take3.setEnabled(false);

            while(!game.gameOver()){
                play();
            }
            outTextArea.append("\nPlayer "+ game.getPlayer() + " wins!\n");
            showWinner(game.getPlayer());
        }
    }

    public void showWinner(int player){
        	
    }

    public void play(){
        int sticks = 0;
        IPlayer computer = null; // Assume no computers playing
        switch (game.getPlayer()) {
            case 1: // Player 1's turn
                computer = game.computer1;
                break;
            case 2: // Player 2's turn
                computer = game.computer2;
                break;
        } // cases
        if (computer != null) { // If computer's turn
            sticks = Integer.parseInt(computer.makeAMove(""));
        }
        if (game.takeSticks(sticks)){
            outTextArea.append("Player "+ game.getPlayer() + ": takes "+ sticks + " sticks\t");
            outTextArea.append("Number of sticks left: " + game.getSticks() + "\n");
            nStricks.setText("Number of sticks left: " + game.getSticks());
            game.changePlayer();
        } // If a legal move
    }

    public void actionPerformed(ActionEvent e){
        // This method is called when the start button is clicked.
        if(e.getSource() == take1){
            game.takeSticks(1);
            outTextArea.append("Player "+ game.getPlayer() + ": takes 1 stick \t");

        }else if(e.getSource() == take2){
            game.takeSticks(2);
            outTextArea.append("Player "+ game.getPlayer() + ": takes 2 sticks\t");


        }else if(e.getSource() == take3){
            game.takeSticks(3);
            outTextArea.append("Player "+ game.getPlayer() + ": takes 3 sticks\t");
        }

        outTextArea.append("Number of sticks left: " + game.getSticks() + "\n");
        game.changePlayer();
        playerTurn.setText("Player " + game.getPlayer() + "'s turn");
        nStricks.setText("Number of sticks left: " + game.getSticks());

        if(nComputers == 1){
            play();
        }
        playerTurn.setText("Player " + game.getPlayer() + "'s turn");

        if(game.getSticks() < 2){
            take2.setEnabled(false);
            take3.setEnabled(false);
        }else if(game.getSticks() < 3){
            take3.setEnabled(false);
        }

        if(game.gameOver()){
            outTextArea.append("Player "+ game.getPlayer() + " wins!\n");
            take1.setEnabled(false);
            take2.setEnabled(false);
            take3.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        // This is the main method that creates a new GameStartScreen object.
        new GameScreen(1);
    }
}
