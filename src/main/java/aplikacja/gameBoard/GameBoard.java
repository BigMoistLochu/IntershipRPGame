package aplikacja.gameBoard;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {



    public GameBoard(){
        this.setPreferredSize(new Dimension(1000,1000));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

}
