
package ticktack;

public class Grid {
    
    private Box[][] cell = new Box[3][3];
    private Box[] fourEdges = new Box[4];         
    private Box[] exceptCenterAndEdges = new Box[4];
    private Box centre;                        
    private Win[] win = new Win[8];   
    private int numOfCellsOccupied = 0;
    
    public Grid() {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                cell[k][l] = new Box(k, l);
            }
        }
        
        for (int k = 0; k < 3; k++) {
            win[k] = new Win(cell[k][0], cell[k][1], cell[k][2]);
        }
        for (int k = 3; k < 6; k++) {
            win[k] = new Win(cell[0][k-3], cell[1][k-3], cell[2][k-3]);
        }
        win[6] = new Win(cell[0][0], cell[1][1], cell[2][2]);
        win[7] = new Win(cell[0][2], cell[1][1], cell[2][0]);
        
       
        int i = 0;
        
        for (int k = 0; k < 3; k += 2) {
            for (int l = 0; l < 3; l += 2) {
                fourEdges[i] = cell[k][l];
                i++;
            }
        }
        
        exceptCenterAndEdges[0] = cell[0][1];
        exceptCenterAndEdges[1] = cell[1][0];
        exceptCenterAndEdges[2] = cell[1][2];
        exceptCenterAndEdges[3] = cell[2][1];
        
        centre = cell[1][1];  
    }
    
  
    public void selectCell(int x, int y, int state){     
        if(!cell[x][y].isUsed()){               
            cell[x][y].setState(state);
            cell[x][y].setUsed(true);
            numOfCellsOccupied++;
        }
    }
    
    public Win[] getWins() {
        return win;
    }
    
    public boolean isCentreFree(){
        if(centre.isUsed()){
            return false;
        }
        else{
            return true;
        }
      }
    
    public Win[] stateSingle(int state){
        int[] State = {-1, -1};
        Win[] p = new Win[8], b = new Win[8] ;
        int i = 0, j = 0;
       
        for (int k = 0; k < 8; k++) {
            if(win[k].isSingleCellAvaiable() && win[k].getSum() == -2){
                State[0] = 0;
                p[i] = win[k];
                i++;
                
            }
            else if(win[k].isSingleCellAvaiable() && win[k].getSum() == -1){
                State[1] = 1;
                b[j] = win[k];
                j++;
            }
        }
        
        if(State[0] == state){
            return p;
        }
        if(State[1] == state){
            return b;
        }
        return null;
        
    }
    
    public Box oneToWin(int state){
        for (int k = 0; k < 8; k++) {
            if(win[k].lastMoveToWin(state)){
                return win[k].getLastCell();
            }
        }
        return null;
    }
    
    public boolean isACorner(Box cell){
        for (int k = 0; k < 4; k++) {
            if(cell.getX() == fourEdges[k].getX() && cell.getY() == fourEdges[k].getY() ){
                return true;
            }
        }
        return false;
    }
    
    public boolean isTheCellUsed(int x, int y){
        return cell[x][y].isUsed();
    }
    
    public boolean isTheGridFull(){
        if(numOfCellsOccupied == 9){
            return true;
        }
        else{
            return false;
        }
        
    }
}