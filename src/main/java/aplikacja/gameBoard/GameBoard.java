package aplikacja.gameBoard;


import aplikacja.entity.Player;
import aplikacja.cache.PlayerCache;
import aplikacja.gameBoard.ui.PaintMapComponent;

import javax.swing.*;
import java.awt.*;


public class GameBoard extends JPanel implements Runnable {

    //Game Board Settings
    private final int ORGINAL_TILE_SIZE = 16; //obrazki tworzymy 16x16
    private final int SCALE = 3;
    private final int TILE_SIZE = SCALE * ORGINAL_TILE_SIZE; //jedna plytka ma wymiar 48x48
    private final int MAX_SCREEN_COLUMN = 21;
    private final int MAX_SCREEN_ROW = 17;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLUMN; //48x16 = 768 pixeli
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 48x12 = 576 pixeli

    //Game FPS(60 frames per second)
    private final int FPS = 60;

    //Game Board Thread
    private Thread gameBoardLoopThread;
    //User Interface to generate components
    private final UserInterface userInterface = new UserInterface();


    public GameBoard() {
        //Load your player to cache
        Player player = new Player((int) (Math.random() * 254));
        PlayerCache.playerList.put(player.getId(), player);

        //Main Setting Board
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        //Game drawing loop
        this.gameBoardLoopThread = new Thread(this);
        gameBoardLoopThread.start();

        //Setting KeyListener
        KeyMovementListener keyMovementListener = new KeyMovementListener(player);
        this.addKeyListener(keyMovementListener);

        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        userInterface.paintComponents(g);
    }

    /**
     * Watek ktory ma za zadanie renderowac obraz gdy obiekty beda zmieniac swoje parametry np gracz czy tekst
     */
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // 1 second : FPS = 0.0166( co tyle bedzie sie wykonywalo renderowanie)
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameBoardLoopThread != null) {

            currentTime = System.nanoTime();

            delta = delta + (currentTime - lastTime) / drawInterval;
            timer = timer + (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                repaint(); //repaint board
                delta = delta - 1;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }


}
