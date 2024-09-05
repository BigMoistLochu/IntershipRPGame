package aplikacja.gameBoard;



import aplikacja.GameStart;
import aplikacja.entity.Player;
import aplikacja.server.ServerService;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMovementListener implements KeyListener {

    private boolean UP_KEY_PRESSED,RIGHT_KEY_PRESSED,LEFT_KEY_PRESSED,DOWN_KEY_PRESSED;

    private Player player;

    private ServerService service = GameStart.service;

    public KeyMovementListener(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            UP_KEY_PRESSED = true;
            player.moveUp();
            service.sendMessage(player.getPositionInBytes());
        }
        else if(e.getKeyCode()==KeyEvent.VK_D) {
            RIGHT_KEY_PRESSED = true;
            player.moveRight();

        }
        else if(e.getKeyCode()==KeyEvent.VK_S) {
            DOWN_KEY_PRESSED = true;
            player.moveDown();
        }
        else if(e.getKeyCode()==KeyEvent.VK_A) {
            LEFT_KEY_PRESSED = true;
            player.moveLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            UP_KEY_PRESSED = false;
        }
        else if(e.getKeyCode()==KeyEvent.VK_D) {
            RIGHT_KEY_PRESSED = false;
        }
        else if(e.getKeyCode()==KeyEvent.VK_S) {
            DOWN_KEY_PRESSED = false;
        }
        else if(e.getKeyCode()==KeyEvent.VK_A) {
            LEFT_KEY_PRESSED = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
