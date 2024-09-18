package aplikacja.gameBoard;



import aplikacja.GameStart;
import aplikacja.model.Player;
import aplikacja.server.ServerService;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMovementListener implements KeyListener {

    private boolean UP_KEY_PRESSED,RIGHT_KEY_PRESSED,LEFT_KEY_PRESSED,DOWN_KEY_PRESSED;

    private Player player;
    private final ServerService service = GameStart.service;

    public KeyMovementListener(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            UP_KEY_PRESSED = true;
            player.moveUp();
            service.sendPositionMessage(player.getPositionInBytes());
        }
        else if(e.getKeyCode()==KeyEvent.VK_D) {
            RIGHT_KEY_PRESSED = true;
            player.moveRight();
            service.sendPositionMessage(player.getPositionInBytes());
        }
        else if(e.getKeyCode()==KeyEvent.VK_S) {
            DOWN_KEY_PRESSED = true;
            player.moveDown();
            service.sendPositionMessage(player.getPositionInBytes());
        }
        else if(e.getKeyCode()==KeyEvent.VK_A) {
            LEFT_KEY_PRESSED = true;
            player.moveLeft();
            service.sendPositionMessage(player.getPositionInBytes());
        } else if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            player.updateDialogStatus();
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
