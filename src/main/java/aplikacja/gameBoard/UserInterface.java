package aplikacja.gameBoard;

import aplikacja.cache.PlayerCache;
import aplikacja.gameBoard.ui.PaintMapComponent;

import java.awt.*;

public class UserInterface {

    private final PaintMapComponent paintMapComponent;

    protected UserInterface(){
        this.paintMapComponent = new PaintMapComponent();
    }

    protected void paintComponents(Graphics graphics){
        paintMap(graphics);
        paintPlayers(graphics);
        paintDialogWindow(graphics);
    }

    private void paintMap(Graphics graphics) {
        paintMapComponent.paintMap(graphics);
    }

    private void paintPlayers(Graphics graphics) {
        PlayerCache.playerList.forEach((key, player) -> {
            graphics.drawImage(player.getSprite(), player.getX(), player.getY(), 48, 48, null);
        });
    }

    private void paintDialogWindow(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        // tlo okna dialogowego
        Color color = new Color(0, 0, 0, 200);
        g.setColor(color);
        g.fillRoundRect(0, 12 * 48, 48 * 21, 48 * 5, 35, 35);

        // obramowanie okna dialogowego
        color = new Color(255, 255, 255);
        g.setColor(color);
        g.setStroke(new BasicStroke(5));
        g.drawRoundRect(5, 12 * 48 + 5, 48 * 21 - 10, 48 * 5 - 10, 25, 25);

        paintText(g,"Witaj na rekrutacji!",0,12 * 48);
    }

    private void paintText(Graphics graphics,String text,int x, int y){
        Graphics2D g = (Graphics2D) graphics;
        // Ustawienia czcionki i koloru tekstu
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(text, x, y);
    }


}
