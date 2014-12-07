

package ticktack;

import javax.swing.JButton;

public class Box{
    private int x = 3;   
    private int y = 3;
    private int state = -1;          
    ///private int user_machine; 
    private boolean used = false;

    
    public Box(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
        used = true;
    }

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        used = false;
    }
    
    public Box(){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getState() {
        return state;
    }

  

    public void setUsed(boolean used) {
        this.used = used;
    }


    public boolean isUsed() {
        return used;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(int state) {
        this.state = state;
    }

}