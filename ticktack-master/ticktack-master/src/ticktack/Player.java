
package ticktack;

public class Player {
    private String name;
    private int state; 
    private Player opponentPlayer;
    int x;
    int y;
    
    public Player(String name, int state){
        this.name = name; 
        this.state = state; 
    }
    
    public void play(Grid table){
        table.selectCell(x, y, state);
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }
    
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
