package aplikacja.entity;

public class Entity {

    protected int id;
    protected int x;
    protected int y;
    protected int direction; //0-down,1-up,2-right,3-left
    protected final int tileMove = 48;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x * tileMove;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y * tileMove;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(byte direction) {
        this.direction = direction;
    }
}
