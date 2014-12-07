
package ticktack;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, int state) {
        super(name, state);
    }
    
    public void play(Grid table, int inputX, int inputY){
        table.selectCell(inputX, inputY, getState());
    }
    
}
