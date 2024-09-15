package aplikacja.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

public class Player extends Entity{


    private BufferedImage down01,left01,right01,up01,up02;
    private BufferedImage sprite;

    private static final Logger logger = Logger.getLogger(Player.class.getName());


    public Player(int id){
        //load sprites
        loadTextures();
        //unique id o player
        this.id = id;
        //start position player
        this.x = 9;
        this.y = 4;
        this.direction = 0;
        this.sprite = down01;
    }

    public Player(int id,int x, int y, int direction){
        //load sprites
        loadTextures();
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.sprite = down01;
    }

    public void moveDown(){
        if(y < 10) y = y + 1;
        direction = 0;
        sprite = down01;
    }

    public void moveUp(){
        if(y > 1) y = y - 1;
        direction = 1;
        sprite = up01;
    }

    public void moveRight(){
       if(x < 19) x = x + 1;
       direction = 2;
       sprite = right01;
    }

    public void moveLeft(){
        if(x > 1) x = x - 1;
        direction = 3;
        sprite = left01;
    }


    public BufferedImage getSprite(){
        return sprite;
    }


    public byte[] getPositionInBytes(){
        byte[] playerInfo = {(byte) id , (byte) x, (byte) y, (byte) direction};
        return playerInfo;
    }


    protected void loadTextures(){
        try{
            this.down01 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_01.png"));
            this.up01 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_01.png"));
            this.up02 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_02.png"));
            this.right01 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_01.png"));
            this.left01 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_01.png"));
        }catch (IOException e){
            logger.severe("Blad przy ladowaniu plikow z folderu: Player");
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
