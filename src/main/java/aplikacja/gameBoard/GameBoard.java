package aplikacja.gameBoard;



import aplikacja.entity.Player;

import javax.swing.*;
import java.awt.*;


public class GameBoard extends JPanel {

    //Game Settings
    private final int ORGINAL_TILE_SIZE = 16; //obrazki tworzymy 16x16
    private final int SCALE = 3;
    private final int TILE_SIZE = SCALE * ORGINAL_TILE_SIZE; //jedna plytka ma wymiar 48x48
    private final int MAX_SCREEN_COLUMN = 16;
    private final int MAX_SCREEN_ROW = 12;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLUMN; //48x16 = 768 pixeli
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 48x12 = 576 pixeli

    private final Player player = new Player(48,48);

    public GameBoard(){
        //Main Setting Board
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        //Setting KeyListener
        KeyMovementListener keyMovementListener = new KeyMovementListener(player);
        this.addKeyListener(keyMovementListener);


        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintPlayer(g);//teraz bedziemy aktualizowac gracza i jego pozycje
        repaint();
    }

    protected void paintPlayer(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(player.getX(), player.getY(), TILE_SIZE,TILE_SIZE);
    }


}
