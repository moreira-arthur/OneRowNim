/**
    * Author: Arthur Moreira Correa
    * NUSP: 13749952 
    * This class is the main class that creates a new GameStartScreen object.
    * In this project to not modify the original code, all the game flow was adapted to the GameScreen class.
    * The GameStartScreen class was kept to start the game.
    * The GameFinalScreen class was kept to show the final screen, with the winner and the reset button.
    * The GameScreen class was created to manage the game flow.
    * The biggest challenge was to adapt the game flow to the GameScreen class, since the original code was not designed to be used in a GUI.
 */

public class OneRowNimGUI {
/**
     * Main method that creates a new GameStartScreen object.
     * @param args
     * 
     */
    public static void main(String[] args) {
        new GameStartScreen();
    }
}
