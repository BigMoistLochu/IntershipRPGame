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
        this.x = 48;
        this.y = 48;
        this.direction = 0;
        loadTextures();
    }

    public void moveUp(){
        y = y - tileMove;
        direction = 1;
    }

    public void moveDown(){
        y = y + tileMove;
        direction = 0;
    }

    public void moveRight(){
       x = x + tileMove;
       direction = 2;
    }

    public void moveLeft(){
        x = x - tileMove;
        direction = 3;
    }

    public byte[] getPositionInBytes(){
        byte[] playerInfo = {(byte) id , (byte) (x / 48) , (byte) (y / 48) , (byte) direction};
        return playerInfo;
    }


    protected void loadTextures(){
        try{
            this.imagePlayer = ImageIO.read(getClass().getResourceAsStream("/player/player1.png"));
        }catch (IOException e){
            logger.severe("Blad przy ladowaniu grafiki gracza");
        }
    }

    public BufferedImage getImagePlayer() {
        return imagePlayer;
    }
}
