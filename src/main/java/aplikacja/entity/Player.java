package aplikacja.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

public class Player extends Entity{

    //Grafika
    private BufferedImage imagePlayer;

    private static final Logger logger = Logger.getLogger(Player.class.getName());


    public Player(int x, int y){
        this.x = x;
        this.y = y;
        loadTextures();
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

    public byte[] getPositionInBytes(){
        byte[] playerInfo = {(byte) (x / 48),(byte) (y / 48)};
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
