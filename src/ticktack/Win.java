
package ticktack;


public class Win 
{
    
    private Box[] win = new Box[3];
    private Box finalCell;
    private int w = 0;
    private int unusedCells = 0;
    private boolean full = false;
    
    
    public Win(Box cell1, Box cell2, Box cell3) {
        win[0] = cell1; 
        win[1] = cell2; 
        win[2] = cell3; 
    }
    public Box[] corners(){
        
        Box[] cll = new Box[2];
        
        if(isAConner(win[0])){
            cll[0] = win[0];
        }
        
        else{
            cll[0] = new Box();
        }
        
        if(isAConner(win[1])){
            cll[1] = win[1];
        }
        
        else{
            cll[1] = new Box();
        }
        
        return cll; 
    }
    
    public boolean lastMoveToWin(int state){
        for (int i = 0; i < 3; i++) {     
            if (!win[i].isUsed()) {
                unusedCells++;
            }
        }
        
        if((unusedCells == 1) && (win[0].getState() == state || win[1].getState() == state)){
            if((win[0].getState() == win[1].getState()) || (win[0].getState() == win[2].getState()) || (win[1].getState() == win[2].getState())){
                unusedCells = 0;
                return true;
            }
            else{
                unusedCells = 0;
                return false;
            }
        }

        else{
            unusedCells = 0;
            return false;
        }
    }
    
    public boolean win(){
        if((win[0].getState() == -1) &&(win[1].getState() == -1) &&(win[2].getState() == -1)){
            return false;
        }
        if(win.length != 0 && (win[0].getState() == win[1].getState()) &&(win[1].getState() == win[2].getState()) ){
            return true;
        }
        else{
            return false;
        } 
    }
    public int wonState(){
        return win[0].getState();
    }
    
    

    public int getSum(){
        int t = 0;
        for (int i = 0; i < 3; i++) {
            t += win[i].getState();
        }
        return t;
    }
    
    
    public boolean isSingleCellAvaiable(){
        if((getSum() != -3)){
            if (((win[0].getState() == -1 && win[1].getState() == -1) || (win[0].getState() == -1 && win[2].getState() == -1) || (win[1].getState() == -1 && win[2].getState() == -1))) {
                return true;
            }
            else{
                return false;
            }
            
        }
        else{
            return false;
        } 
    }

    public Box getLastCell() {
        for (int i = 0; i < 3; i++) {
            if(!win[i].isUsed()){
                finalCell = win[i];
            }
        }
        return finalCell;
    }
    
      public Box[] getTwoEnds(){
        Box[] c = {win[0], win[2]};
        return c;
    }
    
    public boolean isAConner(Box cell){
        for (int k = 0; k < 3; k += 2) {
            for (int l = 0; l < 3; l += 2) {
                if(cell.getX() == k && cell.getY() == l){
                    return true;
                }
                
            }
        }
        return false;
    }
    
  
    
}