package aplikacja.gameBoard.ui;


import aplikacja.model.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PaintDialogComponent {

    private int CURRENT_DIALOG_STATUS = 1;
    private final Map<String,String> QUESTIONS = new HashMap<>();


    public void paintDialogFrame(Graphics graphics) {
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
    }

    public void paintDialogText(Graphics graphics, Player player) {
        switch (player.getDialogStatus()) {
            case 1:
                paintText(graphics, "Witamy na Rekrutacji!", 48 * 1, 48 * 13);
                break;
            case 2:
                System.out.println("Wykonuje sie 2");
                paintText(graphics, "Czeka Cię ciężkie wyzwanie!", 48 * 1, 48 * 13);
                break;
        }
    }

    private void paintText(Graphics graphics, String text, int x, int y) {
        Graphics2D g = (Graphics2D) graphics;

        // Ustawienia czcionki i koloru tekstu
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(text, x, y);
    }
}
