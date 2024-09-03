package aplikacja.entity;

public class Player extends Entity{

    //co ile ma gracz sie przesuwac(tutaj 48 oznacza ze o jedna kratke)
    protected final int tileMove = 48;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        y = y - tileMove;
    }

    public void moveDown(){
        y = y + tileMove;
    }

    public void moveRight(){
       x = x + tileMove;
    }

    public void moveLeft(){
        x = x - tileMove;
    }

}
