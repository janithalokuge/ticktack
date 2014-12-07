
package ticktack;

public class ComputerPlayer extends Player{

    public ComputerPlayer(String name, int state) {
        super(name, state);
    }
    
    public void chose(Grid grid){
        
                Box finaleMove = grid.oneToWin(getState());
                Box opponentFinaltMove = grid.oneToWin(getOpponentPlayer().getState());
                int x = 0, y = 0;
                

                
                if(finaleMove != null){ 
                    x = finaleMove.getX();
                    y = finaleMove.getY();

                }
                
                else if(opponentFinaltMove != null){     
                    x = opponentFinaltMove.getX();
                    y = opponentFinaltMove.getY();

                }
                
                else if(grid.isCentreFree()){   
                    x = 1;
                    y = 1;

                }
                
                else if(grid.stateSingle(getOpponentPlayer().getState()) != null && grid.stateSingle(getOpponentPlayer().getState()).length != 0){ 
                    Win[] wayToGo = grid.stateSingle(1);
                    Box[] corners;
                    Box corner = null;
                    int i;
                    for (i = 0; wayToGo[i] != null && i < wayToGo.length ; i++) {
                        corners = wayToGo[i].corners();
                        
                        if(corners[0].getX() == 3 && corners[1].getX() == 3){ 
                            continue;
                        }
                        int j ;
                        for (j = 0; j < 2; j++) {
                            if (!corners[j].isUsed() && corners[j].getX() != 3) {
                                corner = corners[j];
                                break;
                            }
                        }
                        if( j < 2){
                            break;
                        }
                    }
                    
                    if(i == wayToGo.length || wayToGo[i] == null){ 
                        for (int j = 0; j < wayToGo.length; j++) {
                            Box[] twoEnds = wayToGo[j].getTwoEnds();
                            int k;
                            for (k = 0; k < 2; k++) {
                                if(!twoEnds[k].isUsed()){
                                    corner = twoEnds[k];
                                    break;
                                }
                            }
                            if(k < 2){
                                break;
                            }
                        }
                    }
                    x = corner.getX();
                    y = corner.getY();

                }

                this.x = x;
                this.y = y;
                
    }
    
    public void play(Grid table){
        table.selectCell(this.x, this.y, getState());
       
    }
}
