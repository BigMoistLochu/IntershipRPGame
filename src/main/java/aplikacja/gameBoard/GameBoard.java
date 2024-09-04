package aplikacja.gameBoard;



import aplikacja.entity.Player;
import aplikacja.server.ServerService;
import aplikacja.server.implementation.ServerDaoImpl;

import javax.swing.*;
import java.awt.*;


public class GameBoard extends JPanel implements Runnable{

    //Game Board Settings
    private final int ORGINAL_TILE_SIZE = 16; //obrazki tworzymy 16x16
    private final int SCALE = 3;
    private final int TILE_SIZE = SCALE * ORGINAL_TILE_SIZE; //jedna plytka ma wymiar 48x48
    private final int MAX_SCREEN_COLUMN = 16;
    private final int MAX_SCREEN_ROW = 12;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLUMN; //48x16 = 768 pixeli
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 48x12 = 576 pixeli

    //Game FPS(60 frames per second)
    private final int FPS = 60;

    //Game Board Thread
    private Thread gameBoardLoopThread;

    private final Player player = new Player(48,48);


    public GameBoard(){
        //Main Setting Board
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        //Create Game Loop Thread
        this.gameBoardLoopThread = new Thread(this);
        gameBoardLoopThread.start(); //start thread working

        //Setting KeyListener
        KeyMovementListener keyMovementListener = new KeyMovementListener(player);
        this.addKeyListener(keyMovementListener);


        this.setFocusable(true);
    }

    /**
     * Watek ktory ma za zadanie renderowac obraz gdy obiekty beda zmieniac swoje parametry np gracz czy npc
     */
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 1 second : FPS = 0.0166( co tyle bedzie sie wykonywalo renderowanie)
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameBoardLoopThread != null){

            currentTime = System.nanoTime();

            delta = delta + (currentTime-lastTime) / drawInterval;
            timer = timer + (currentTime-lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                repaint();
                delta = delta - 1;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateGame(g);
    }

    private void updateGame(Graphics g){
        paintMap(g);
        paintPlayer(g);
    }

    private void paintMap(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(144, 144, TILE_SIZE,TILE_SIZE);
    }

    private void paintPlayer(Graphics graphics){
        graphics.drawImage(player.getImagePlayer(), player.getX(), player.getY(),TILE_SIZE,TILE_SIZE, null);
    }




}
