package aplikacja.gameBoard;

import aplikacja.entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {

    private boolean UP_KEY_PRESSED,RIGHT_KEY_PRESSED,LEFT_KEY_PRESSED,DOWN_KEY_PRESSED;
    private Player player;

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            UP_KEY_PRESSED = true;
            player.moveUp();
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
