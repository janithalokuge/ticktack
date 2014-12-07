
package ticktack;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Game {

    private final Grid gameTable;
    private Player player1, player2;

    public Game(Player player1, Player player2) {
        this.gameTable = new Grid();
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean gameOver() {
        Win[] wins;
        boolean finished = false;
        wins = gameTable.getWins();
        for (int i = 0; i < 8; i++) {  
            try {
                if (wins[i].win()) {
                     
                    if (wins[i].wonState() == player1.getState()) {
                        JOptionPane.showMessageDialog(new JDialog(), "\n" + "Game WON by " + player1.getName());
                    }
                    if (wins[i].wonState() == player2.getState()) {
                        JOptionPane.showMessageDialog(new JDialog(), "\n" + "Game WON by " + player2.getName());
                    }
                    finished = true;
                }

            } catch (Exception e) {
            }
        }
        if (gameTable.isTheGridFull()) {          
            JOptionPane.showMessageDialog(new JDialog(), "\n  Draw!    " );
            finished = true;
        }
        return finished;
    }

    public void swapPlayer() {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
    }

    public Grid getGameTable() {
        return gameTable;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
