package aplikacja.map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class MapCreator {

    private BufferedImage grass;
    private BufferedImage ground;
    private BufferedImage brick;

    public MapCreator() {
        try {
            this.grass = ImageIO.read(getClass().getResourceAsStream("/floor/grass.png"));
            this.ground = ImageIO.read(getClass().getResourceAsStream("/floor/title.png"));
            this.brick = ImageIO.read(getClass().getResourceAsStream("/floor/brick.png"));

        }catch (IOException e){
            System.out.println("Blad przy ladowaniu plikow z folderu: MAP");
        }
    }

    public BufferedImage getGrass(){
        return grass;
    }

    public BufferedImage getGround(){
        return ground;
    }

    public BufferedImage getBrick(){
        return brick;
    }

    public void paintMap(Graphics graphics){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/map/map01.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int column = 0;
            int row = 0;

            while ((line = bufferedReader.readLine()) != null){
                String[] numbers = line.split(" ");
                for(String number : numbers){
                    int theNumber = Integer.parseInt(number);

                    if(theNumber == 0){
                        graphics.drawImage(getGrass(), row * 48, column * 48,48,48, null);
                    } else if (theNumber == 1) {
                        graphics.drawImage(getGround(), row * 48, column * 48,48,48, null);
                    } else if (theNumber == 2) {
                        graphics.drawImage(getBrick(), row * 48, column * 48,48,48, null);
                    }

                    row++;
                }

                column++;
                row = 0;
            }
        }catch (IOException e){
            System.out.println("Blad z tworzeniem mapy");
        }
    }



}
