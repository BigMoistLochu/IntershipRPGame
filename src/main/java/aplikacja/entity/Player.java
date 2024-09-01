package aplikacja.entity;

import javax.swing.*;

public class Player {

    private int x;
    private int y;

    public Player(){}

    public void moveUp(){
        if(this.y >= 0 && this.y > 48){
            this.y = this.y - 48;
        }
    }

    public void moveDown(){
        if(this.y >= 0){
            this.y = this.y + 48;
        }
    }

    public void moveRight(){
        if(this.x >= 0){
            this.x = this.x + 48;
        }
    }

    public void moveLeft(){
        if(this.x >= 0 && this.x > 48){
            this.x = this.x - 48;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
