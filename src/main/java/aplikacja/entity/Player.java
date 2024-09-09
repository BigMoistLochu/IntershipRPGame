package aplikacja.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

public class Player extends Entity{

    //Grafika
    private BufferedImage imagePlayer;

    private static final Logger logger = Logger.getLogger(Player.class.getName());


    public Player(int id){
        //unique id o player
        this.id = id;

        //start position player
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        loadTextures();
    }

    public Player(int id,int x, int y, int direction){
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction;
        loadTextures();
    }

    public void moveUp(){
        y = y - 1;
        direction = 1;
    }

    public void moveDown(){
        y = y + 1;
        direction = 0;
    }

    public void moveRight(){
       x = x + 1;
       direction = 2;
    }

    public void moveLeft(){
        x = x - 1;
        direction = 3;
    }

    public BufferedImage getImagePlayer() {
        return imagePlayer;
    }

    public byte[] getPositionInBytes(){
        byte[] playerInfo = {(byte) id , (byte) x, (byte) y, (byte) direction};
        return playerInfo;
    }


    protected void loadTextures(){
        try{
            this.imagePlayer = ImageIO.read(getClass().getResourceAsStream("/player/player1.png"));
        }catch (IOException e){
            logger.severe("Blad przy ladowaniu grafiki gracza");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
