package aplikacja.gameBoard.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class PaintMapComponent {

    private BufferedImage grass,ground,brick;
    private BufferedImage answerA,answerB,answerC,answerD;

    public PaintMapComponent() {
        try {
            this.grass = ImageIO.read(getClass().getResourceAsStream("/floor/grass.png"));
            this.ground = ImageIO.read(getClass().getResourceAsStream("/floor/title.png"));
            this.brick = ImageIO.read(getClass().getResourceAsStream("/floor/brick.png"));
            this.answerA = ImageIO.read(getClass().getResourceAsStream("/floor/answer_a.png"));
            this.answerB = ImageIO.read(getClass().getResourceAsStream("/floor/answer_b.png"));
            this.answerC = ImageIO.read(getClass().getResourceAsStream("/floor/answer_c.png"));
            this.answerD = ImageIO.read(getClass().getResourceAsStream("/floor/answer_d.png"));

        }catch (IOException e){
            System.out.println("Blad przy ladowaniu plikow z folderu: MAP");
        }
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
                        graphics.drawImage(grass, row * 48, column * 48,48,48, null);
                    } else if (theNumber == 1) {
                        graphics.drawImage(ground, row * 48, column * 48,48,48, null);
                    } else if (theNumber == 2) {
                        graphics.drawImage(brick, row * 48, column * 48,48,48, null);
                    } else if (theNumber == 3) {
                        graphics.drawImage(answerA, row * 48, column * 48,48,48, null);
                    }
                    else if (theNumber == 4) {
                        graphics.drawImage(answerB, row * 48, column * 48,48,48, null);
                    }
                    else if (theNumber == 5) {
                        graphics.drawImage(answerC, row * 48, column * 48,48,48, null);
                    }
                    else if (theNumber == 6) {
                        graphics.drawImage(answerD, row * 48, column * 48,48,48, null);
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
